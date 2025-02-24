package dev.thomasglasser.mineraculouskamikotizations.client.renderer.item;

import dev.thomasglasser.mineraculous.core.component.MineraculousDataComponents;
import dev.thomasglasser.mineraculouskamikotizations.core.component.MineraculousKamikotizationsDataComponents;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.mineraculouskamikotizations.world.item.ParasolItem;
import dev.thomasglasser.mineraculouskamikotizations.world.item.WeatherControlParasolItem;
import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;

public class MineraculousKamikotizationsItemProperties {
    public static void init() {
        ItemPropertyFunction openFunction = (stack, level, entity, seed) -> {
            if (stack.has(MineraculousDataComponents.ACTIVE))
                return 1;
            return 0;
        };
        for (DeferredItem<ParasolItem> parasol : MineraculousKamikotizationsItems.PARASOLS.values()) {
            ItemProperties.register(parasol.get(), ParasolItem.OPEN_PROPERTY_ID, openFunction);
        }
        ItemProperties.register(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), ParasolItem.OPEN_PROPERTY_ID, openFunction);
        ItemProperties.register(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), WeatherControlParasolItem.ABILITY_PROPERTY_ID, (stack, level, entity, seed) -> {
            WeatherControlParasolItem.Ability ability = stack.get(MineraculousKamikotizationsDataComponents.WEATHER_CONTROL_PARASOL_ABILITY);
            if (ability == null)
                return 0;
            return ability.ordinal() + 1;
        });
    }
}
