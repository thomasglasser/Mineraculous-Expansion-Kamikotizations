package dev.thomasglasser.mineraculouskamikotizations.data.recipes;

import dev.thomasglasser.mineraculouskamikotizations.tags.MineraculousKamikotizationsItemTags;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.tommylib.api.data.recipes.ExtendedRecipeProvider;
import dev.thomasglasser.tommylib.api.tags.ConventionalItemTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class MineraculousKamikotizationsRecipeProvider extends ExtendedRecipeProvider {
    public MineraculousKamikotizationsRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput, HolderLookup.Provider registries) {
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.WHITE_PARASOL.get(), Items.WHITE_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.ORANGE_PARASOL.get(), Items.ORANGE_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.MAGENTA_PARASOL.get(), Items.MAGENTA_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.LIGHT_BLUE_PARASOL.get(), Items.LIGHT_BLUE_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.YELLOW_PARASOL.get(), Items.YELLOW_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.LIME_PARASOL.get(), Items.LIME_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.PINK_PARASOL.get(), Items.PINK_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.GRAY_PARASOL.get(), Items.GRAY_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.LIGHT_GRAY_PARASOL.get(), Items.LIGHT_GRAY_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.CYAN_PARASOL.get(), Items.CYAN_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.PURPLE_PARASOL.get(), Items.PURPLE_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.BLUE_PARASOL.get(), Items.BLUE_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.BROWN_PARASOL.get(), Items.BROWN_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.GREEN_PARASOL.get(), Items.GREEN_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.RED_PARASOL.get(), Items.RED_CARPET);
        parasolFromCarpet(recipeOutput, MineraculousKamikotizationsItems.BLACK_PARASOL.get(), Items.BLACK_CARPET);

        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.WHITE_PARASOL.get(), ConventionalItemTags.WHITE_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.ORANGE_PARASOL.get(), ConventionalItemTags.ORANGE_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.MAGENTA_PARASOL.get(), ConventionalItemTags.MAGENTA_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.LIGHT_BLUE_PARASOL.get(), ConventionalItemTags.LIGHT_BLUE_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.YELLOW_PARASOL.get(), ConventionalItemTags.YELLOW_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.LIME_PARASOL.get(), ConventionalItemTags.LIME_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.PINK_PARASOL.get(), ConventionalItemTags.PINK_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.GRAY_PARASOL.get(), ConventionalItemTags.GRAY_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.LIGHT_GRAY_PARASOL.get(), ConventionalItemTags.LIGHT_GRAY_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.CYAN_PARASOL.get(), ConventionalItemTags.CYAN_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.PURPLE_PARASOL.get(), ConventionalItemTags.PURPLE_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.BLUE_PARASOL.get(), ConventionalItemTags.BLUE_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.BROWN_PARASOL.get(), ConventionalItemTags.BROWN_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.GREEN_PARASOL.get(), ConventionalItemTags.GREEN_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.RED_PARASOL.get(), ConventionalItemTags.RED_DYES);
        parasolFromDye(recipeOutput, MineraculousKamikotizationsItems.BLACK_PARASOL.get(), ConventionalItemTags.BLACK_DYES);
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

    protected void parasolFromDye(RecipeOutput recipeOutput, ItemLike parasol, TagKey<Item> dyeTag) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, parasol)
                .requires(MineraculousKamikotizationsItemTags.PARASOLS)
                .requires(dyeTag)
                .unlockedBy("has_parasol", has(MineraculousKamikotizationsItemTags.PARASOLS))
                .unlockedBy("has_self", has(parasol))
                .save(recipeOutput, RecipeBuilder.getDefaultRecipeId(parasol).withPath(path -> path + "_from_dye"));
    }
}
