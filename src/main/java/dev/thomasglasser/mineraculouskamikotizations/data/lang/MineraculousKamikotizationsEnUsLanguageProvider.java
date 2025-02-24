package dev.thomasglasser.mineraculouskamikotizations.data.lang;

import dev.thomasglasser.mineraculous.data.lang.MineraculousEnUsLanguageProvider;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.client.MineraculousKamikotizationsKeyMappings;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.kamikotization.MineraculousKamikotizationsKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsCreativeModeTabs;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.mineraculouskamikotizations.world.item.ParasolItem;
import dev.thomasglasser.mineraculouskamikotizations.world.item.WeatherControlParasolItem;
import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import java.util.Map;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;

public class MineraculousKamikotizationsEnUsLanguageProvider extends MineraculousEnUsLanguageProvider {
    public MineraculousKamikotizationsEnUsLanguageProvider(PackOutput output) {
        super(output, MineraculousKamikotizations.MOD_ID);
    }

    @Override
    protected void addTranslations() {
        for (Map.Entry<DyeColor, DeferredItem<ParasolItem>> parasol : MineraculousKamikotizationsItems.PARASOLS.entrySet()) {
            add(parasol.getValue().get(), capitalize(parasol.getKey().getName()) + " Parasol");
        }
        add(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), "Weather Control Parasol");

        add(WeatherControlParasolItem.Ability.ICE, "Ice");
        add(WeatherControlParasolItem.Ability.LIGHTNING, "Lightning");
        add(WeatherControlParasolItem.Ability.WEATHER, "Weather");
        add(WeatherControlParasolItem.Ability.WIND, "Wind");

        add(MineraculousKamikotizationsKamikotizations.WEATHER_CONTROL, "Weather Control");

        add(MineraculousKamikotizationsCreativeModeTabs.MINERACULOUS_KAMIKOTIZATIONS.get(), "Mineraculous Expansion: Kamikotizations");

        add(MineraculousKamikotizationsKeyMappings.OPEN_PARASOL.get(), "Open Parasol");
    }
}
