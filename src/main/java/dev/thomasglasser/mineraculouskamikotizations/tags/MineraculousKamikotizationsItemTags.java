package dev.thomasglasser.mineraculouskamikotizations.tags;

import dev.thomasglasser.tommylib.api.tags.TagUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MineraculousKamikotizationsItemTags {
    public static final TagKey<Item> UMBRELLA_TOOLS = createC("tools/umbrella");

    private static TagKey<Item> createC(String name) {
        return TagUtils.createConventional(Registries.ITEM, name);
    }
}
