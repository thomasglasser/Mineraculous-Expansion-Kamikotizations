package dev.thomasglasser.mineraculouskamikotizations.data.lang;

import dev.thomasglasser.mineraculous.data.lang.MineraculousEnUsLanguageProvider;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.kamikotization.MineraculousKamikotizationsKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.mineraculouskamikotizations.world.item.WeatherControlParasolItem;
import net.minecraft.data.PackOutput;

public class MineraculousKamikotizationsEnUsLanguageProvider extends MineraculousEnUsLanguageProvider {
    public MineraculousKamikotizationsEnUsLanguageProvider(PackOutput output) {
        super(output, MineraculousKamikotizations.MOD_ID);
    }

    @Override
    protected void addTranslations() {
        add(MineraculousKamikotizationsItems.PARASOL.get(), "Parasol");
        add(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), "Weather Control Parasol");

        add(WeatherControlParasolItem.Ability.ICE, "Ice");
        add(WeatherControlParasolItem.Ability.LIGHTNING, "Lightning");
        add(WeatherControlParasolItem.Ability.WEATHER, "Weather");
        add(WeatherControlParasolItem.Ability.WIND, "Wind");

        add(MineraculousKamikotizationsKamikotizations.WEATHER_CONTROL, "Weather Control");
    }
}
