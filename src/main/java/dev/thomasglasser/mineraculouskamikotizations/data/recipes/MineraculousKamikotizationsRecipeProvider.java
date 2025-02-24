package dev.thomasglasser.mineraculouskamikotizations.data.recipes;

import dev.thomasglasser.mineraculouskamikotizations.tags.MineraculousKamikotizationsItemTags;
import dev.thomasglasser.mineraculouskamikotizations.world.item.MineraculousKamikotizationsItems;
import dev.thomasglasser.mineraculouskamikotizations.world.item.ParasolItem;
import dev.thomasglasser.tommylib.api.data.recipes.ExtendedRecipeProvider;
import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import dev.thomasglasser.tommylib.api.tags.ConventionalItemTags;
import java.util.Map;
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
        for (Map.Entry<DyeColor, DeferredItem<ParasolItem>> parasol : MineraculousKamikotizationsItems.PARASOLS.entrySet()) {
            parasolFromCarpet(recipeOutput, parasol.getValue().get(), BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(parasol.getKey().getName() + "_carpet")));
            parasolFromDye(recipeOutput, parasol.getValue().get(), ConventionalItemTags.forDyeColor(parasol.getKey()));
        }
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
