package dev.thomasglasser.mineraculouskamikotizations.data;

import dev.thomasglasser.mineraculous.core.registries.MineraculousRegistries;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.data.advancements.MineraculousKamikotizationsAdvancementProvider;
import dev.thomasglasser.mineraculouskamikotizations.data.curios.MineraculousKamikotizationsCuriosProvider;
import dev.thomasglasser.mineraculouskamikotizations.data.datamaps.MineraculousKamikotizationsDataMapProvider;
import dev.thomasglasser.mineraculouskamikotizations.data.lang.MineraculousKamikotizationsEnUsLanguageProvider;
import dev.thomasglasser.mineraculouskamikotizations.data.loot.MineraculousKamikotizationsLootTables;
import dev.thomasglasser.mineraculouskamikotizations.data.models.MineraculousKamikotizationsItemModelProvider;
import dev.thomasglasser.mineraculouskamikotizations.data.particles.MineraculousKamikotizationsParticleDescriptionProvider;
import dev.thomasglasser.mineraculouskamikotizations.data.recipes.MineraculousKamikotizationsRecipeProvider;
import dev.thomasglasser.mineraculouskamikotizations.data.tags.MineraculousKamikotizationsDamageTypeTagsProvider;
import dev.thomasglasser.mineraculouskamikotizations.data.tags.MineraculousKamikotizationsItemTagsProvider;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.kamikotization.MineraculousKamikotizationsKamikotizations;
import dev.thomasglasser.tommylib.api.data.info.ModRegistryDumpReport;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class MineraculousKamikotizationsDataGenerators {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(MineraculousRegistries.KAMIKOTIZATION, MineraculousKamikotizationsKamikotizations::bootstrap);

    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();

        MineraculousKamikotizationsEnUsLanguageProvider enUs = new MineraculousKamikotizationsEnUsLanguageProvider(packOutput);

        DatapackBuiltinEntriesProvider datapackBuiltinEntriesProvider = new DatapackBuiltinEntriesProvider(packOutput, registries, BUILDER, Set.of(MineraculousKamikotizations.MOD_ID));
        generator.addProvider(includeServer, datapackBuiltinEntriesProvider);
        registries = datapackBuiltinEntriesProvider.getRegistryProvider();
        generator.addProvider(includeServer, new ModRegistryDumpReport(packOutput, MineraculousKamikotizations.MOD_ID, registries));
        generator.addProvider(includeServer, new MineraculousKamikotizationsItemTagsProvider(packOutput, registries, CompletableFuture.completedFuture(null), existingFileHelper));
        generator.addProvider(includeServer, new MineraculousKamikotizationsDamageTypeTagsProvider(packOutput, registries, existingFileHelper));
        generator.addProvider(includeServer, new MineraculousKamikotizationsAdvancementProvider(packOutput, registries, existingFileHelper, enUs));
        generator.addProvider(includeServer, new MineraculousKamikotizationsDataMapProvider(packOutput, registries));
        generator.addProvider(includeServer, new MineraculousKamikotizationsLootTables(packOutput, registries));
        generator.addProvider(includeServer, new MineraculousKamikotizationsRecipeProvider(packOutput, registries));
        generator.addProvider(includeServer, new MineraculousKamikotizationsCuriosProvider(packOutput, existingFileHelper, registries));

        generator.addProvider(includeClient, enUs);
        generator.addProvider(includeClient, new MineraculousKamikotizationsParticleDescriptionProvider(packOutput, existingFileHelper));
        generator.addProvider(includeClient, new MineraculousKamikotizationsItemModelProvider(packOutput, existingFileHelper));
    }
}
