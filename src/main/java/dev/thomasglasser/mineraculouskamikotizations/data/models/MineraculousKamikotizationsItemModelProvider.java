package dev.thomasglasser.mineraculouskamikotizations.data.models;

import dev.thomasglasser.mineraculous.api.client.renderer.item.MineraculousItemProperties;
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
            singleTexture(MineraculousKamikotizationsItems.PARASOLS.get(color).getId().getPath(), mcItemLoc("handheld"), "layer0", mcItemLoc("apple"))
                    .override()
                    .predicate(MineraculousItemProperties.ACTIVE, 1)
                    .model(singleTexture(MineraculousKamikotizationsItems.PARASOLS.get(color).getId().getPath() + "_open", mcItemLoc("handheld"), "layer0", mcItemLoc("bread")))
                    .end();
        }
    }
}
