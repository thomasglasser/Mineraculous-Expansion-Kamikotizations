package dev.thomasglasser.mineraculouskamikotizations.data.models;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.tommylib.api.data.models.ExtendedItemModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MineraculousKamikotizationsItemModelProvider extends ExtendedItemModelProvider {
    public MineraculousKamikotizationsItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MineraculousKamikotizations.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (DyeColor color : DyeColor.values()) {
            // TODO: Parasols
            basicItem(MineraculousKamikotizationsItems.BUBBLE_WANDS.get(color).get());
        }
    }
}
