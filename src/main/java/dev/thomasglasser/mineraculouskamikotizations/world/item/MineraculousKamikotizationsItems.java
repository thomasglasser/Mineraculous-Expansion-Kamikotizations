package dev.thomasglasser.mineraculouskamikotizations.world.item;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import net.minecraft.world.item.Item;

public class MineraculousKamikotizationsItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MineraculousKamikotizations.MOD_ID);

    public static final DeferredItem<?> PARASOL = ITEMS.register("parasol", () -> new Item(new Item.Properties()));
    public static final DeferredItem<?> WEATHER_CONTROL_PARASOL = ITEMS.register("weather_control_parasol", () -> new Item(new Item.Properties()));

    public static void init() {}
}
