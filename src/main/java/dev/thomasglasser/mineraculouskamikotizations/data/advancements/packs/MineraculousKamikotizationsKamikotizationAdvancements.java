package dev.thomasglasser.mineraculouskamikotizations.data.advancements.packs;

import dev.thomasglasser.mineraculous.advancements.critereon.KamikotizationTransformTrigger;
import dev.thomasglasser.mineraculous.world.item.armor.MineraculousArmors;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.entity.kamikotization.MineraculousKamikotizationsKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.tommylib.api.data.advancements.ExtendedAdvancementGenerator;
import java.util.Map;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.core.HolderLookup;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class MineraculousKamikotizationsKamikotizationAdvancements extends ExtendedAdvancementGenerator {
    public MineraculousKamikotizationsKamikotizationAdvancements(LanguageProvider enUs) {
        super(MineraculousKamikotizations.MOD_ID, "kamikotization", enUs);
    }

    @Override
    public void generate(HolderLookup.Provider provider) {
        AdvancementHolder root = root(MineraculousArmors.KAMIKOTIZATION.HEAD.get(), "root", MineraculousKamikotizations.modLoc("textures/gui/advancements/backgrounds/kamikotization.png"), AdvancementType.TASK, false, false, false, null, AdvancementRequirements.Strategy.AND, Map.of(
                "get_kamikotized", KamikotizationTransformTrigger.TriggerInstance.transformed()), "Kamikotizations", "Canon kamikotizations");

        AdvancementHolder transformWeatherControl = create(root, MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.get(), "transform_weather_control", AdvancementType.TASK, true, true, false, null, AdvancementRequirements.Strategy.AND, Map.of(
                "transform_weather_control", KamikotizationTransformTrigger.TriggerInstance.transformed(MineraculousKamikotizationsKamikotizations.WEATHER_CONTROL)), "Weather Control", "Show the world who the best weather player really is...");
    }
}
