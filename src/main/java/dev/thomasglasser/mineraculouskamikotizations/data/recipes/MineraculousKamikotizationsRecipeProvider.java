package dev.thomasglasser.mineraculouskamikotizations.data.recipes;

import dev.thomasglasser.mineraculouskamikotizations.tags.MineraculousKamikotizationsItemTags;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.tommylib.api.data.recipes.ExtendedRecipeProvider;
import dev.thomasglasser.tommylib.api.tags.ConventionalItemTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public class MineraculousKamikotizationsRecipeProvider extends ExtendedRecipeProvider {
    public MineraculousKamikotizationsRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput, HolderLookup.Provider registries) {
        for (DyeColor color : DyeColor.values()) {
            TagKey<Item> dyeTag = ConventionalItemTags.forDyeColor(color);

            parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.PARASOLS.get(color).get(), BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(color.getName() + "_carpet")));
            itemFromDye(recipeOutput, MineraculousKamikotizationsItems.PARASOLS.get(color).get(), MineraculousKamikotizationsItemTags.PARASOLS, dyeTag);

            bubbleWandFromStainedGlass(recipeOutput, MineraculousKamikotizationsItems.BUBBLE_WANDS.get(color).get(), BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(color.getName() + "_stained_glass")));
            itemFromDye(recipeOutput, MineraculousKamikotizationsItems.BUBBLE_WANDS.get(color).get(), MineraculousKamikotizationsItemTags.BUBBLE_WANDS, dyeTag);
        }
    }

    protected void itemFromDye(RecipeOutput recipeOutput, ItemLike result, TagKey<Item> itemTag, TagKey<Item> dyeTag) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, result)
                .requires(itemTag)
                .requires(dyeTag)
                .unlockedBy("has_item", has(itemTag))
                .unlockedBy("has_self", has(result))
                .save(recipeOutput, RecipeBuilder.getDefaultRecipeId(result).withPath(path -> path + "_from_dye"));
    }

    protected void parasolFromCarpet(RecipeOutput recipeOutput, ItemLike parasol, ItemLike carpet) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, parasol)
                .pattern(" c ")
                .pattern("csc")
                .pattern(" s ")
                .define('c', carpet)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy("has_carpet", has(carpet))
                .unlockedBy("has_parasol", has(MineraculousKamikotizationsItemTags.PARASOLS))
                .unlockedBy("has_self", has(parasol))
                .save(recipeOutput);
    }

    protected void bubbleWandFromStainedGlass(RecipeOutput recipeOutput, ItemLike bubbleWand, ItemLike stainedGlass) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, bubbleWand)
                .pattern(" c ")
                .pattern(" g ")
                .define('c', ConventionalItemTags.COPPER_INGOTS)
                .define('g', stainedGlass)
                .unlockedBy("has_stained_glass", has(stainedGlass))
                .unlockedBy("has_bubble_wand", has(MineraculousKamikotizationsItemTags.BUBBLE_WANDS))
                .unlockedBy("has_self", has(bubbleWand))
                .save(recipeOutput);
    }
}
