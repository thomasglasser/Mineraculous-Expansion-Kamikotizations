package dev.thomasglasser.mineraculouskamikotizations.world.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import dev.thomasglasser.mineraculous.core.component.MineraculousDataComponents;
import dev.thomasglasser.mineraculous.world.entity.kamikotization.Kamikotization;
import dev.thomasglasser.mineraculous.world.item.armor.MineraculousArmors;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.kamikotization.MineraculousKamikotizationsKamikotizations;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForgeMod;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class BubbleSwordItem extends Item implements ICurioItem {
    public static final AttributeModifier FLIGHT_MODIFIER = new AttributeModifier(MineraculousKamikotizations.modLoc("sword_flight"), 1, AttributeModifier.Operation.ADD_VALUE);

    private static Multimap<Holder<Attribute>, AttributeModifier> CURIOS_ATTRIBUTE_MODIFIERS;

    public BubbleSwordItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        ItemStack chestplate = slotContext.entity().getItemBySlot(EquipmentSlot.CHEST);
        ResourceKey<Kamikotization> kamikotization = chestplate.get(MineraculousDataComponents.KAMIKOTIZATION);
        return chestplate.is(MineraculousArmors.KAMIKOTIZATION.CHEST) && kamikotization != null && kamikotization == MineraculousKamikotizationsKamikotizations.BUBBLE_CAPTURE;
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        if (CURIOS_ATTRIBUTE_MODIFIERS == null) {
            CURIOS_ATTRIBUTE_MODIFIERS = HashMultimap.create();
            CURIOS_ATTRIBUTE_MODIFIERS.put(NeoForgeMod.CREATIVE_FLIGHT, FLIGHT_MODIFIER);
        }
        return CURIOS_ATTRIBUTE_MODIFIERS;
    }
}
