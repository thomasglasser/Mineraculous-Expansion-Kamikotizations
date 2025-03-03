package dev.thomasglasser.mineraculouskamikotizations.data.particles;

import dev.thomasglasser.mineraculouskamikotizations.core.particles.MineraculousKamikotizationsParticleTypes;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

public class MineraculousKamikotizationsParticleDescriptionProvider extends ParticleDescriptionProvider {
    public MineraculousKamikotizationsParticleDescriptionProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, fileHelper);
    }

    @Override
    protected void addDescriptions() {
        spriteSet(MineraculousKamikotizationsParticleTypes.FLOATING_BUBBLE.get(),
                ResourceLocation.withDefaultNamespace("bubble"),
                ResourceLocation.withDefaultNamespace("bubble_pop_0"),
                ResourceLocation.withDefaultNamespace("bubble_pop_1"),
                ResourceLocation.withDefaultNamespace("bubble_pop_2"),
                ResourceLocation.withDefaultNamespace("bubble_pop_3"),
                ResourceLocation.withDefaultNamespace("bubble_pop_4"));
    }
}
