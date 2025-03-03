package dev.thomasglasser.mineraculouskamikotizations.data.curios;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosDataProvider;

public class MineraculousKamikotizationsCuriosProvider extends CuriosDataProvider {
    public static final String SLOT_BACK = "back";

    public MineraculousKamikotizationsCuriosProvider(PackOutput output, ExistingFileHelper fileHelper, CompletableFuture<HolderLookup.Provider> registries) {
        super(MineraculousKamikotizations.MOD_ID, output, fileHelper, registries);
    }

    @Override
    public void generate(HolderLookup.Provider registries, ExistingFileHelper fileHelper) {
        createEntities("tool_holders")
                .addPlayer()
                .addSlots(
                        SLOT_BACK);
    }
}
