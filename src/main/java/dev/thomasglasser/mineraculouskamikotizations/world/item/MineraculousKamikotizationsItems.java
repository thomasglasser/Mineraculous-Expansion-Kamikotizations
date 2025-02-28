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

    public static final Map<DyeColor, DeferredItem<ParasolItem>> PARASOLS = parasols();
    public static final DeferredItem<WeatherControlParasolItem> WEATHER_CONTROL_PARASOL = ITEMS.register("weather_control_parasol", () -> new WeatherControlParasolItem(new Item.Properties().stacksTo(1).attributes(ItemAttributeModifiers.builder().add(NeoForgeMod.CREATIVE_FLIGHT, new AttributeModifier(MineraculousKamikotizations.modLoc("parasol_flight"), 1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.ANY).build())));

    private static SortedMap<DyeColor, DeferredItem<ParasolItem>> parasols() {
        SortedMap<DyeColor, DeferredItem<ParasolItem>> parasols = new Object2ObjectLinkedOpenHashMap<>();
        for (DyeColor color : DyeColor.values()) {
            parasols.put(color, ITEMS.register(color.getName() + "_parasol", () -> new ParasolItem(new Item.Properties().stacksTo(1))));
        }
        return parasols;
    }

    public static void init() {}
}
