package dev.thomasglasser.mineraculouskamikotizations.data.advancements;

import dev.thomasglasser.mineraculouskamikotizations.data.advancements.packs.MineraculousKamikotizationsKamikotizationAdvancements;
import dev.thomasglasser.tommylib.api.data.advancements.ExtendedAdvancementProvider;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class MineraculousKamikotizationsAdvancementProvider extends ExtendedAdvancementProvider {
    public MineraculousKamikotizationsAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, BiConsumer<String, String> lang, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, ReferenceOpenHashSet.of(
                new MineraculousKamikotizationsKamikotizationAdvancements(lang)));
    }
}
