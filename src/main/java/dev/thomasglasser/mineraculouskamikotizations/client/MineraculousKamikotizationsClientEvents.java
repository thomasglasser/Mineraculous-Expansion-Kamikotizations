package dev.thomasglasser.mineraculouskamikotizations.client;

import dev.thomasglasser.mineraculous.world.item.MineraculousItems;
import dev.thomasglasser.mineraculouskamikotizations.client.renderer.item.MineraculousKamikotizationsItemProperties;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class MineraculousKamikotizationsClientEvents {
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        MineraculousKamikotizationsItemProperties.init();
    }

    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

        } else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {

        } else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {

        } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {

        } else if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {

        } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(Items.NETHERITE_HOE.getDefaultInstance(), MineraculousKamikotizationsItems.PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.insertAfter(MineraculousItems.BUTTERFLY_CANE.toStack(), MineraculousKamikotizationsItems.WEATHER_CONTROL_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        } else if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {

        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        } else if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            // Must be in alphabetical order
        } else if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {

        }
    }
}
