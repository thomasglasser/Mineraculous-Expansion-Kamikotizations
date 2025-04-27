package dev.thomasglasser.mineraculouskamikotizations.client.renderer.entity;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.BubblePrison;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BubblePrisonRenderer<T extends BubblePrison> extends EntityRenderer<T> {
    public BubblePrisonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        // TODO: Texture
        return MineraculousKamikotizations.modLoc("");
    }
}
