package dev.thomasglasser.mineraculouskamikotizations.world.item;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.NeoForgeMod;

public class MineraculousKamikotizationsItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MineraculousKamikotizations.MOD_ID);

    public static final DeferredItem<?> PARASOL = ITEMS.register("parasol", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<WeatherControlParasolItem> WEATHER_CONTROL_PARASOL = ITEMS.register("weather_control_parasol", () -> new WeatherControlParasolItem(new Item.Properties().stacksTo(1).attributes(ItemAttributeModifiers.builder().add(NeoForgeMod.CREATIVE_FLIGHT, new AttributeModifier(MineraculousKamikotizations.modLoc("parasol_flight"), 1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND).build())));

    public static void init() {}
}
