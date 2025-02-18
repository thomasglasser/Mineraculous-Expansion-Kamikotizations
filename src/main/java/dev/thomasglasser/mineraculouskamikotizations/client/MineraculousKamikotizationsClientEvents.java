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
            event.insertAfter(Items.NETHERITE_HOE.getDefaultInstance(), MineraculousKamikotizationsItems.WHITE_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.WHITE_PARASOL.toStack(), MineraculousKamikotizationsItems.ORANGE_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.ORANGE_PARASOL.toStack(), MineraculousKamikotizationsItems.MAGENTA_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.MAGENTA_PARASOL.toStack(), MineraculousKamikotizationsItems.LIGHT_BLUE_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.LIGHT_BLUE_PARASOL.toStack(), MineraculousKamikotizationsItems.YELLOW_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.YELLOW_PARASOL.toStack(), MineraculousKamikotizationsItems.LIME_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.LIME_PARASOL.toStack(), MineraculousKamikotizationsItems.PINK_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.PINK_PARASOL.toStack(), MineraculousKamikotizationsItems.GRAY_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.GRAY_PARASOL.toStack(), MineraculousKamikotizationsItems.LIGHT_GRAY_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.LIGHT_GRAY_PARASOL.toStack(), MineraculousKamikotizationsItems.CYAN_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.CYAN_PARASOL.toStack(), MineraculousKamikotizationsItems.PURPLE_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.PURPLE_PARASOL.toStack(), MineraculousKamikotizationsItems.BLUE_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.BLUE_PARASOL.toStack(), MineraculousKamikotizationsItems.BROWN_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.BROWN_PARASOL.toStack(), MineraculousKamikotizationsItems.GREEN_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.GREEN_PARASOL.toStack(), MineraculousKamikotizationsItems.RED_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(MineraculousKamikotizationsItems.RED_PARASOL.toStack(), MineraculousKamikotizationsItems.BLACK_PARASOL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
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
