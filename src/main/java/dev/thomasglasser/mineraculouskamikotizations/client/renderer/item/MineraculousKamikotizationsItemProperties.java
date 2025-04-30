package dev.thomasglasser.mineraculouskamikotizations.client.renderer.item;

import dev.thomasglasser.mineraculous.client.renderer.item.MineraculousItemProperties;
import dev.thomasglasser.mineraculouskamikotizations.core.component.MineraculousKamikotizationsDataComponents;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import net.minecraft.client.renderer.item.ItemProperties;

public class MineraculousKamikotizationsItemProperties {
    public static void init() {
        ItemProperties.register(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), MineraculousItemProperties.ABILITY, MineraculousItemProperties.getEnumAbilityPropertyFunction(MineraculousKamikotizationsDataComponents.WEATHER_CONTROL_PARASOL_ABILITY.get()));
    }
}
