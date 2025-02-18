package dev.thomasglasser.mineraculouskamikotizations.data.lang;

import dev.thomasglasser.mineraculous.data.lang.MineraculousEnUsLanguageProvider;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.kamikotization.MineraculousKamikotizationsKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsCreativeModeTabs;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.mineraculouskamikotizations.world.item.WeatherControlParasolItem;
import net.minecraft.data.PackOutput;

public class MineraculousKamikotizationsEnUsLanguageProvider extends MineraculousEnUsLanguageProvider {
    public MineraculousKamikotizationsEnUsLanguageProvider(PackOutput output) {
        super(output, MineraculousKamikotizations.MOD_ID);
    }

    @Override
    protected void addTranslations() {
        add(MineraculousKamikotizationsItems.WHITE_PARASOL.get(), "White Parasol");
        add(MineraculousKamikotizationsItems.ORANGE_PARASOL.get(), "Orange Parasol");
        add(MineraculousKamikotizationsItems.MAGENTA_PARASOL.get(), "Magenta Parasol");
        add(MineraculousKamikotizationsItems.LIGHT_BLUE_PARASOL.get(), "Light Blue Parasol");
        add(MineraculousKamikotizationsItems.YELLOW_PARASOL.get(), "Yellow Parasol");
        add(MineraculousKamikotizationsItems.LIME_PARASOL.get(), "Lime Parasol");
        add(MineraculousKamikotizationsItems.PINK_PARASOL.get(), "Pink Parasol");
        add(MineraculousKamikotizationsItems.GRAY_PARASOL.get(), "Gray Parasol");
        add(MineraculousKamikotizationsItems.LIGHT_GRAY_PARASOL.get(), "Light Gray Parasol");
        add(MineraculousKamikotizationsItems.CYAN_PARASOL.get(), "Cyan Parasol");
        add(MineraculousKamikotizationsItems.PURPLE_PARASOL.get(), "Purple Parasol");
        add(MineraculousKamikotizationsItems.BLUE_PARASOL.get(), "Blue Parasol");
        add(MineraculousKamikotizationsItems.BROWN_PARASOL.get(), "Brown Parasol");
        add(MineraculousKamikotizationsItems.GREEN_PARASOL.get(), "Green Parasol");
        add(MineraculousKamikotizationsItems.RED_PARASOL.get(), "Red Parasol");
        add(MineraculousKamikotizationsItems.BLACK_PARASOL.get(), "Black Parasol");
        add(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), "Weather Control Parasol");

        add(WeatherControlParasolItem.Ability.ICE, "Ice");
        add(WeatherControlParasolItem.Ability.LIGHTNING, "Lightning");
        add(WeatherControlParasolItem.Ability.WEATHER, "Weather");
        add(WeatherControlParasolItem.Ability.WIND, "Wind");

        add(MineraculousKamikotizationsKamikotizations.WEATHER_CONTROL, "Weather Control");

        add(MineraculousKamikotizationsCreativeModeTabs.MINERACULOUS_KAMIKOTIZATIONS.get(), "Mineraculous Expansion: Kamikotizations");
    }
}
