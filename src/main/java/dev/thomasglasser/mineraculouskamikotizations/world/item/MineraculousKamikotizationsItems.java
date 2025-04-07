package dev.thomasglasser.mineraculouskamikotizations.world.item;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import java.util.Map;
import java.util.SortedMap;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.NeoForgeMod;

public class MineraculousKamikotizationsItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MineraculousKamikotizations.MOD_ID);

    // Kamikotizables
    public static final Map<DyeColor, DeferredItem<ParasolItem>> PARASOLS = parasols();
    public static final Map<DyeColor, DeferredItem<BubbleWandItem>> BUBBLE_WANDS = bubbleWands();

    // Kamikotization Tools
    public static final DeferredItem<WeatherControlParasolItem> WEATHER_CONTROL_PARASOL = ITEMS.register("weather_control_parasol", () -> new WeatherControlParasolItem(new Item.Properties().stacksTo(1).attributes(ItemAttributeModifiers.builder().add(NeoForgeMod.CREATIVE_FLIGHT, new AttributeModifier(MineraculousKamikotizations.modLoc("parasol_flight"), 1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.ANY).build())));
    public static final DeferredItem<BubbleSwordItem> BUBBLE_SWORD = ITEMS.register("bubble_sword", () -> new BubbleSwordItem(new Item.Properties().stacksTo(1).attributes(ItemAttributeModifiers.builder().add(NeoForgeMod.CREATIVE_FLIGHT, BubbleSwordItem.FLIGHT_MODIFIER, EquipmentSlotGroup.ANY).build())));

    private static SortedMap<DyeColor, DeferredItem<ParasolItem>> parasols() {
        SortedMap<DyeColor, DeferredItem<ParasolItem>> parasols = new Object2ObjectLinkedOpenHashMap<>();
        for (DyeColor color : DyeColor.values()) {
            parasols.put(color, ITEMS.register(color.getName() + "_parasol", () -> new ParasolItem(new Item.Properties().stacksTo(1))));
        }
        return parasols;
    }

    private static SortedMap<DyeColor, DeferredItem<BubbleWandItem>> bubbleWands() {
        SortedMap<DyeColor, DeferredItem<BubbleWandItem>> bubbleWands = new Object2ObjectLinkedOpenHashMap<>();
        for (DyeColor color : DyeColor.values()) {
            bubbleWands.put(color, ITEMS.register(color.getName() + "_bubble_wand", () -> new BubbleWandItem(new Item.Properties().stacksTo(1).durability(100))));
        }
        return bubbleWands;
    }

    public static void init() {}
}
