package dev.thomasglasser.mineraculouskamikotizations;

import dev.thomasglasser.mineraculouskamikotizations.client.MineraculousKamikotizationsClientEvents;
import dev.thomasglasser.mineraculouskamikotizations.client.MineraculousKamikotizationsKeyMappings;
import dev.thomasglasser.mineraculouskamikotizations.core.component.MineraculousKamikotizationsDataComponents;
import dev.thomasglasser.mineraculouskamikotizations.core.particles.MineraculousKamikotizationsParticleTypes;
import dev.thomasglasser.mineraculouskamikotizations.data.MineraculousKamikotizationsDataGenerators;
import dev.thomasglasser.mineraculouskamikotizations.network.MineraculousKamikotizationsPayloads;
import dev.thomasglasser.mineraculouskamikotizations.world.attachment.MineraculousKamikotizationsAttachmentTypes;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.MineraculousKamikotizationsEntityEvents;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.MineraculousKamikotizationsEntityTypes;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsCreativeModeTabs;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.tommylib.api.platform.TommyLibServices;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(MineraculousKamikotizations.MOD_ID)
public class MineraculousKamikotizations {
    public static final String MOD_ID = "mineraculouskamikotizations";
    public static final String MOD_NAME = "Mineraculous Expansion: Kamikotizations";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public MineraculousKamikotizations(IEventBus bus) {
        LOGGER.info("Initializing {} for {} in a {} environment...", MOD_NAME, TommyLibServices.PLATFORM.getPlatformName(), TommyLibServices.PLATFORM.getEnvironmentName());

        MineraculousKamikotizationsDataComponents.init();
        MineraculousKamikotizationsItems.init();
        MineraculousKamikotizationsAttachmentTypes.init();
        MineraculousKamikotizationsCreativeModeTabs.init();
        MineraculousKamikotizationsEntityTypes.init();
        MineraculousKamikotizationsParticleTypes.init();

        bus.addListener(MineraculousKamikotizationsDataGenerators::onGatherData);

        bus.addListener(MineraculousKamikotizationsPayloads::onRegisterPackets);

        NeoForge.EVENT_BUS.addListener(MineraculousKamikotizationsEntityEvents::onEntityMount);

        if (TommyLibServices.PLATFORM.isClientSide()) {
            MineraculousKamikotizationsKeyMappings.init();

            bus.addListener(MineraculousKamikotizationsClientEvents::onFMLClientSetup);
            bus.addListener(MineraculousKamikotizationsClientEvents::onBuildCreativeModeTabContents);
            bus.addListener(MineraculousKamikotizationsClientEvents::onRegisterRenderer);
            bus.addListener(MineraculousKamikotizationsClientEvents::onRegisterParticleProviders);
        }
    }

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
