package dev.thomasglasser.mineraculouskamikotizations.world.entity;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.projectile.IceCharge;
import dev.thomasglasser.tommylib.api.registration.DeferredHolder;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class MineraculousKamikotizationsEntityTypes {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, MineraculousKamikotizations.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<IceCharge>> ICE_CHARGE = ENTITY_TYPES.register("ice_charge", () -> EntityType.Builder.<IceCharge>of(IceCharge::new, MobCategory.MISC)
            .sized(0.3125F, 0.3125F)
            .build("ice_charge"));
    public static final DeferredHolder<EntityType<?>, EntityType<BubblePrison>> BUBBLE_PRISON = ENTITY_TYPES.register("bubble_prison", () -> EntityType.Builder.<BubblePrison>of(BubblePrison::new, MobCategory.MISC)
            .sized(4F, 4F)
            .build("bubble_prison"));

    public static void init() {}
}
