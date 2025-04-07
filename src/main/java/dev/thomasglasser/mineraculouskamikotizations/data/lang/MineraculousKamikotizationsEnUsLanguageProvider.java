package dev.thomasglasser.mineraculouskamikotizations.data.lang;

import dev.thomasglasser.mineraculous.data.lang.MineraculousEnUsLanguageProvider;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.client.MineraculousKamikotizationsKeyMappings;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.MineraculousKamikotizationsEntityTypes;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.kamikotization.MineraculousKamikotizationsKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsCreativeModeTabs;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.mineraculouskamikotizations.world.item.WeatherControlParasolItem;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;

public class MineraculousKamikotizationsEnUsLanguageProvider extends MineraculousEnUsLanguageProvider {
    public MineraculousKamikotizationsEnUsLanguageProvider(PackOutput output) {
        super(output, MineraculousKamikotizations.MOD_ID);
    }

    @Override
    protected void addTranslations() {
        for (DyeColor color : DyeColor.values()) {
            add(MineraculousKamikotizationsItems.PARASOLS.get(color).get(), capitalize(color.getName()) + " Parasol");
            add(MineraculousKamikotizationsItems.BUBBLE_WANDS.get(color).get(), capitalize(color.getName()) + " Bubble Wand");
        }

        add(MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), "Weather Control Parasol");
        add(MineraculousKamikotizationsItems.BUBBLE_SWORD.get(), "Bubble Sword");

        add(WeatherControlParasolItem.Ability.ICE, "Ice");
        add(WeatherControlParasolItem.Ability.LIGHTNING, "Lightning");
        add(WeatherControlParasolItem.Ability.WEATHER, "Weather");
        add(WeatherControlParasolItem.Ability.WIND, "Wind");

        add(MineraculousKamikotizationsKamikotizations.WEATHER_CONTROL, "Weather Control");
        add(MineraculousKamikotizationsKamikotizations.BUBBLE_CAPTURE, "Bubble Capture");

        add(MineraculousKamikotizationsCreativeModeTabs.MINERACULOUS_KAMIKOTIZATIONS.get(), "Mineraculous Expansion: Kamikotizations");

        add(MineraculousKamikotizationsKeyMappings.OPEN_PARASOL.get(), "Open Parasol");

        add(MineraculousKamikotizationsEntityTypes.ICE_CHARGE.get(), "Ice Charge");
    }
}
