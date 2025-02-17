package dev.thomasglasser.mineraculouskamikotizations.client.renderer.item;

import dev.thomasglasser.mineraculouskamikotizations.core.component.MineraculousKamikotizationsDataComponents;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.mineraculouskamikotizations.world.item.WeatherControlParasolItem;
import net.minecraft.client.renderer.item.ItemProperties;

public class MineraculousKamikotizationsItemProperties {
    public static void init() {
        ItemProperties.register(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), WeatherControlParasolItem.ABILITY_PROPERTY_ID, (stack, level, entity, seed) -> {
            WeatherControlParasolItem.Ability ability = stack.get(MineraculousKamikotizationsDataComponents.WEATHER_CONTROL_PARASOL_ABILITY);
            if (ability == null)
                return 0;
            return ability.ordinal() + 1;
        });
    }
}
