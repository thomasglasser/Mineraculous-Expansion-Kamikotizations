package dev.thomasglasser.mineraculouskamikotizations.world.entity.kamikotization;

import com.mojang.datafixers.util.Either;
import dev.thomasglasser.mineraculous.core.registries.MineraculousRegistries;
import dev.thomasglasser.mineraculous.world.entity.kamikotization.Kamikotization;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.tags.MineraculousKamikotizationsItemTags;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import java.util.List;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;

public class MineraculousKamikotizationsKamikotizations {
    public static final ResourceKey<Kamikotization> WEATHER_CONTROL = create("weather_control");

    private static ResourceKey<Kamikotization> create(String id) {
        return ResourceKey.create(MineraculousRegistries.KAMIKOTIZATION, MineraculousKamikotizations.modLoc(id));
    }

    public static void bootstrap(BootstrapContext<Kamikotization> context) {
        context.register(WEATHER_CONTROL, new Kamikotization(
                "Stormy Weather",
                ItemPredicate.Builder.item().of(MineraculousKamikotizationsItemTags.UMBRELLA_TOOLS).withCount(MinMaxBounds.Ints.exactly(1)).build(),
                Either.left(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.toStack()),
                List.of()));
    }
}
