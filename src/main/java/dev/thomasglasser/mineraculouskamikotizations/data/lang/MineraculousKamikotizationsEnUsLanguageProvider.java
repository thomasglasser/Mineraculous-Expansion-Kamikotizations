package dev.thomasglasser.mineraculouskamikotizations.data.lang;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.kamikotization.MineraculousKamikotizationsKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.tommylib.api.data.lang.ExtendedEnUsLanguageProvider;
import net.minecraft.data.PackOutput;

public class MineraculousKamikotizationsEnUsLanguageProvider extends ExtendedEnUsLanguageProvider {
    public MineraculousKamikotizationsEnUsLanguageProvider(PackOutput output) {
        super(output, MineraculousKamikotizations.MOD_ID);
    }

    @Override
    protected void addTranslations() {
        add(MineraculousKamikotizationsItems.PARASOL.get(), "Parasol");
        add(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), "Weather Control Parasol");

        add(MineraculousKamikotizationsKamikotizations.WEATHER_CONTROL, "Weather Control");
    }
}
