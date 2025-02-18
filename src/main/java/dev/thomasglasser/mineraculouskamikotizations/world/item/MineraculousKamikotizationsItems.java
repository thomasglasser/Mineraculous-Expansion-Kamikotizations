package dev.thomasglasser.mineraculouskamikotizations.world.item;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import java.util.function.Supplier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.NeoForgeMod;

public class MineraculousKamikotizationsItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MineraculousKamikotizations.MOD_ID);

    public static final Supplier<Item> PARASOL_PROVIDER = () -> new Item(new Item.Properties().stacksTo(1));
    public static final DeferredItem<?> WHITE_PARASOL = ITEMS.register("white_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> ORANGE_PARASOL = ITEMS.register("orange_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> MAGENTA_PARASOL = ITEMS.register("magenta_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> LIGHT_BLUE_PARASOL = ITEMS.register("light_blue_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> YELLOW_PARASOL = ITEMS.register("yellow_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> LIME_PARASOL = ITEMS.register("lime_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> PINK_PARASOL = ITEMS.register("pink_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> GRAY_PARASOL = ITEMS.register("gray_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> LIGHT_GRAY_PARASOL = ITEMS.register("light_gray_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> CYAN_PARASOL = ITEMS.register("cyan_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> PURPLE_PARASOL = ITEMS.register("purple_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> BLUE_PARASOL = ITEMS.register("blue_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> BROWN_PARASOL = ITEMS.register("brown_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> GREEN_PARASOL = ITEMS.register("green_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> RED_PARASOL = ITEMS.register("red_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<?> BLACK_PARASOL = ITEMS.register("black_parasol", PARASOL_PROVIDER);
    public static final DeferredItem<WeatherControlParasolItem> WEATHER_CONTROL_PARASOL = ITEMS.register("weather_control_parasol", () -> new WeatherControlParasolItem(new Item.Properties().stacksTo(1).attributes(ItemAttributeModifiers.builder().add(NeoForgeMod.CREATIVE_FLIGHT, new AttributeModifier(MineraculousKamikotizations.modLoc("parasol_flight"), 1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND).build())));

    public static void init() {}
}
