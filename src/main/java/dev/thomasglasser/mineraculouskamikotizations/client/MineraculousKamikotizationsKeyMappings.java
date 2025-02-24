package dev.thomasglasser.mineraculouskamikotizations.client;

import com.mojang.blaze3d.platform.InputConstants;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.tommylib.api.platform.TommyLibServices;
import java.util.function.Supplier;
import net.minecraft.client.KeyMapping;

public class MineraculousKamikotizationsKeyMappings {
    public static final String MIRACULOUS_KAMIKOTIZATIONS_CATEGORY = "key.categories." + MineraculousKamikotizations.MOD_ID;

    public static final Supplier<KeyMapping> OPEN_PARASOL = register("open_parasol", InputConstants.KEY_O, MIRACULOUS_KAMIKOTIZATIONS_CATEGORY);

    public static Supplier<KeyMapping> register(String name, int key, String category) {
        return TommyLibServices.CLIENT.registerKeyMapping(MineraculousKamikotizations.modLoc(name), key, category);
    }

    public static void init() {}
}
