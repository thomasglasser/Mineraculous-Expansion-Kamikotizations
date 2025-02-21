package dev.thomasglasser.mineraculouskamikotizations.world.item;

import com.mojang.serialization.Codec;
import dev.thomasglasser.mineraculous.client.MineraculousClientEvents;
import dev.thomasglasser.mineraculous.client.MineraculousClientUtils;
import dev.thomasglasser.mineraculous.client.MineraculousKeyMappings;
import dev.thomasglasser.mineraculous.client.gui.screens.RadialMenuOption;
import dev.thomasglasser.mineraculous.world.attachment.MineraculousAttachmentTypes;
import dev.thomasglasser.mineraculous.world.entity.MineraculousEntityEvents;
import dev.thomasglasser.mineraculous.world.entity.miraculous.MineraculousMiraculous;
import dev.thomasglasser.mineraculous.world.item.KamikotizedPowerSourceItem;
import dev.thomasglasser.mineraculous.world.level.storage.MiraculousRecoveryDataHolder;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.core.component.MineraculousKamikotizationsDataComponents;
import dev.thomasglasser.mineraculouskamikotizations.network.ServerboundSetWeatherControlParasolAbilityPayload;
import dev.thomasglasser.mineraculouskamikotizations.world.attachment.MineraculousKamikotizationsAttachmentTypes;
import dev.thomasglasser.tommylib.api.platform.TommyLibServices;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class WeatherControlParasolItem extends Item implements KamikotizedPowerSourceItem {
    public static final ResourceLocation ABILITY_PROPERTY_ID = MineraculousKamikotizations.modLoc("ability");

    public WeatherControlParasolItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !player.isUsingItem()) {
            if (level.isClientSide() && (player.getMainHandItem() == stack || player.getOffhandItem() == stack)) {
                InteractionHand hand = player.getMainHandItem() == stack ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
                CompoundTag playerData = TommyLibServices.ENTITY.getPersistentData(entity);
                int waitTicks = playerData.getInt(MineraculousEntityEvents.TAG_WAIT_TICKS);
                if (waitTicks <= 0 && MineraculousClientUtils.hasNoScreenOpen() && MineraculousKeyMappings.OPEN_TOOL_WHEEL.get().isDown()) {
                    int color = level.holderOrThrow(MineraculousMiraculous.BUTTERFLY).value().color().getValue();
                    ResolvableProfile resolvableProfile = stack.get(DataComponents.PROFILE);
                    if (resolvableProfile != null) {
                        Player owner = player.level().getPlayerByUUID(resolvableProfile.id().orElse(resolvableProfile.gameProfile().getId()));
                        if (owner != null && owner.getData(MineraculousAttachmentTypes.KAMIKOTIZATION).isPresent())
                            color = owner.getData(MineraculousAttachmentTypes.KAMIKOTIZATION).get().kamikoData().nameColor();
                    }
                    MineraculousClientEvents.openToolWheel(color, stack, option -> {
                        if (option instanceof Ability ability) {
                            TommyLibServices.NETWORK.sendToServer(new ServerboundSetWeatherControlParasolAbilityPayload(hand, ability));
                            stack.set(MineraculousKamikotizationsDataComponents.WEATHER_CONTROL_PARASOL_ABILITY, ability);
                        }
                    }, Ability.values());
                    playerData.putInt(MineraculousEntityEvents.TAG_WAIT_TICKS, 10);
                    TommyLibServices.ENTITY.setPersistentData(entity, playerData, false);
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        Ability ability = itemStack.get(MineraculousKamikotizationsDataComponents.WEATHER_CONTROL_PARASOL_ABILITY);
        ResolvableProfile resolvableProfile = itemStack.get(DataComponents.PROFILE);
        Player owner = resolvableProfile != null ? player.level().getPlayerByUUID(resolvableProfile.id().orElse(resolvableProfile.gameProfile().getId())) : null;
        if (owner == null)
            owner = player;
        if (ability == null) return InteractionResultHolder.fail(itemStack);
        ServerLevel overworld = level.getServer() != null ? level.getServer().overworld() : null;
        if (ability == Ability.ICE) {
            if (overworld != null) {
                HitResult hitResult = ProjectileUtil.getHitResultOnViewVector(player, entity -> entity.isAlive() && entity.isPickable(), 100);
                Map<BlockPos, BlockState> alteredBlocks = new HashMap<>();
                if (hitResult instanceof BlockHitResult blockHitResult) {
                    BlockPos pos = blockHitResult.getBlockPos();
                    for (int i = -1; i <= 1; i++) {
                        for (int k = -1; k <= 1; k++) {
                            BlockPos blockpos = pos.offset(i, 0, k).above();
                            if (level.canSeeSky(blockpos))
                                blockpos = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, pos.offset(i, 0, k));
                            if (level.getBlockState(blockpos).canBeReplaced() && !level.getBlockState(blockpos.below()).is(Blocks.ICE)) {
                                BlockState oldState = level.getBlockState(blockpos);
                                alteredBlocks.put(blockpos, oldState);
                                level.setBlockAndUpdate(blockpos, Blocks.ICE.defaultBlockState());
                            }
                        }
                    }
                } else if (hitResult instanceof EntityHitResult entityHitResult) {
                    Entity target = entityHitResult.getEntity();
                    ((MiraculousRecoveryDataHolder) overworld).mineraculous$getMiraculousRecoveryEntityData().putRecoverable(owner.getUUID(), target);
                    target.setTicksFrozen(Integer.MAX_VALUE);
                    target.moveTo(target.blockPosition().getBottomCenter());
                    target.setDeltaMovement(0, 0, 0);
                    List<BlockPos> inside = getInsidePos(target);
                    int blocksWide = Mth.ceil(target.getBbWidth());
                    int blocksHigh = Mth.ceil(target.getBbHeight());
                    for (int i = -blocksWide; i <= blocksWide; i++) {
                        for (int j = -1; j <= blocksHigh; j++) {
                            for (int k = -blocksWide; k <= blocksWide; k++) {
                                BlockPos blockpos = target.blockPosition().offset(i, j, k);
                                BlockState oldState = level.getBlockState(blockpos);
                                if (!inside.contains(blockpos) && oldState.canBeReplaced()) {
                                    alteredBlocks.put(blockpos, oldState);
                                    level.setBlockAndUpdate(blockpos, Blocks.ICE.defaultBlockState());
                                }
                            }
                        }
                    }
                }
                ((MiraculousRecoveryDataHolder) overworld).mineraculous$getMiraculousRecoveryBlockData().putRecoverable(owner.getUUID(), alteredBlocks);
            }
        } else {
            if (ability == Ability.LIGHTNING) {
                if (overworld != null) {
                    HitResult hitresult = ProjectileUtil.getHitResultOnViewVector(player, entity -> entity.isAlive() && entity.isPickable(), 100);
                    Player finalOwner = owner;
                    LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level) {
                        @Override
                        public void tick() {
                            if (!visualOnly) {
                                List<Entity> hit = this.level()
                                        .getEntities(
                                                this,
                                                new AABB(this.getX() - 3.0, this.getY() - 3.0, this.getZ() - 3.0, this.getX() + 3.0, this.getY() + 6.0 + 3.0, this.getZ() + 3.0),
                                                Entity::isAlive);
                                for (Entity entity : hit)
                                    ((MiraculousRecoveryDataHolder) overworld).mineraculous$getMiraculousRecoveryEntityData().putRecoverable(finalOwner.getUUID(), entity);
                            }
                            super.tick();
                        }

                        @Override
                        protected void spawnFire(int extraIgnitions) {
                            if (!this.visualOnly && !this.level().isClientSide && this.level().getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
                                Map<BlockPos, BlockState> alteredBlocks = new HashMap<>();
                                BlockPos blockpos = this.blockPosition();
                                BlockState oldState = this.level().getBlockState(blockpos);
                                BlockState blockstate = BaseFireBlock.getState(this.level(), blockpos);
                                if (oldState.isAir() && blockstate.canSurvive(this.level(), blockpos)) {
                                    this.level().setBlockAndUpdate(blockpos, blockstate);
                                    this.blocksSetOnFire++;
                                    alteredBlocks.put(blockpos, oldState);
                                }

                                for (int i = 0; i < extraIgnitions; i++) {
                                    BlockPos blockpos1 = blockpos.offset(this.random.nextInt(3) - 1, this.random.nextInt(3) - 1, this.random.nextInt(3) - 1);
                                    BlockState oldState1 = this.level().getBlockState(blockpos1);
                                    blockstate = BaseFireBlock.getState(this.level(), blockpos1);
                                    if (oldState1.isAir() && blockstate.canSurvive(this.level(), blockpos1)) {
                                        this.level().setBlockAndUpdate(blockpos1, blockstate);
                                        this.blocksSetOnFire++;
                                        alteredBlocks.put(blockpos1, oldState1);
                                    }
                                }
                                ((MiraculousRecoveryDataHolder) overworld).mineraculous$getMiraculousRecoveryBlockData().putRecoverable(finalOwner.getUUID(), alteredBlocks);
                            }
                        }
                    };
                    lightningBolt.setPos(level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, BlockPos.containing(hitresult.getLocation())).getBottomCenter());
                    level.addFreshEntity(lightningBolt);
                }
            } else if (ability == Ability.WEATHER) {
                if (overworld != null) {
                    if (overworld.isThundering())
                        overworld.setWeatherParameters(ServerLevel.RAIN_DELAY.sample(overworld.random), 0, false, false);
                    else if (overworld.isRaining())
                        overworld.setWeatherParameters(0, ServerLevel.THUNDER_DURATION.sample(overworld.random), true, true);
                    else
                        overworld.setWeatherParameters(0, ServerLevel.RAIN_DURATION.sample(overworld.random), true, false);
                    overworld.setData(MineraculousKamikotizationsAttachmentTypes.WEATHER_MODIFIED, true);
                }
            } else if (ability == Ability.WIND) {
                if (!level.isClientSide()) {
                    Player finalOwner = owner;
                    WindCharge windcharge = new WindCharge(player, level, player.position().x(), player.getEyePosition().y(), player.position().z()) {
                        @Override
                        protected void onHitEntity(EntityHitResult result) {
                            if (overworld != null)
                                ((MiraculousRecoveryDataHolder) overworld).mineraculous$getMiraculousRecoveryEntityData().putRecoverable(finalOwner.getUUID(), result.getEntity());
                            super.onHitEntity(result);
                        }
                    };
                    windcharge.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                    level.addFreshEntity(windcharge);
                }

                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WIND_CHARGE_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            player.getCooldowns().addCooldown(this, 10);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    private static List<BlockPos> getInsidePos(Entity target) {
        AABB aabb = target.getBoundingBox();
        BlockPos startPos = BlockPos.containing(aabb.minX + 1.0E-7, aabb.minY + 1.0E-7, aabb.minZ + 1.0E-7);
        BlockPos endPos = BlockPos.containing(aabb.maxX - 1.0E-7, aabb.maxY - 1.0E-7, aabb.maxZ - 1.0E-7);
        List<BlockPos> inside = new ArrayList<>();
        for (int i = startPos.getX(); i <= endPos.getX(); i++) {
            for (int j = startPos.getY(); j <= endPos.getY(); j++) {
                for (int k = startPos.getZ(); k <= endPos.getZ(); k++) {
                    inside.add(new BlockPos(i, j, k));
                }
            }
        }
        return inside;
    }

    @Override
    public void restore(LivingEntity entity) {
        MiraculousRecoveryDataHolder recoveryDataHolder = (MiraculousRecoveryDataHolder) entity.level().getServer().overworld();
        recoveryDataHolder.mineraculous$getMiraculousRecoveryBlockData().recover(entity.getUUID(), (ServerLevel) entity.level());
        recoveryDataHolder.mineraculous$getMiraculousRecoveryItemData().markRecovered(entity.getUUID());
        recoveryDataHolder.mineraculous$getMiraculousRecoveryEntityData().recover(entity.getUUID(), (ServerLevel) entity.level(), e -> e);
        if (entity.getServer().overworld().getData(MineraculousKamikotizationsAttachmentTypes.WEATHER_MODIFIED))
            entity.getServer().overworld().resetWeatherCycle();
    }

    public enum Ability implements RadialMenuOption, StringRepresentable {
        ICE,
        LIGHTNING,
        WEATHER,
        WIND;

        public static final Codec<Ability> CODEC = Codec.STRING.xmap(Ability::of, Ability::getSerializedName);
        public static final StreamCodec<ByteBuf, Ability> STREAM_CODEC = ByteBufCodecs.STRING_UTF8.map(Ability::of, Ability::getSerializedName);

        private final String translationKey;

        Ability() {
            this.translationKey = MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.getId().toLanguageKey("ability", getSerializedName());
        }

        @Override
        public String translationKey() {
            return translationKey;
        }

        @Override
        public String getSerializedName() {
            return name().toLowerCase();
        }

        public static Ability of(String name) {
            return valueOf(name.toUpperCase());
        }
    }
}
