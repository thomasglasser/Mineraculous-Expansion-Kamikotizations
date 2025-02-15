package dev.thomasglasser.mineraculouskamikotizations;

import dev.thomasglasser.mineraculouskamikotizations.data.MineraculousKamikotizationsDataGenerators;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.tommylib.api.platform.TommyLibServices;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(MineraculousKamikotizations.MOD_ID)
public class MineraculousKamikotizations {
    public static final String MOD_ID = "mineraculouskamikotizations";
    public static final String MOD_NAME = "Mineraculous Expansion: Kamikotizations";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public MineraculousKamikotizations(IEventBus modEventBus) {
        LOGGER.info("Initializing {} for {} in a {} environment...", MOD_NAME, TommyLibServices.PLATFORM.getPlatformName(), TommyLibServices.PLATFORM.getEnvironmentName());

        MineraculousKamikotizationsItems.init();

        modEventBus.addListener(MineraculousKamikotizationsDataGenerators::onGatherData);
    }

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
