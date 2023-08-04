package com.tiviacz.pizzacraft.init;

import com.tiviacz.pizzacraft.PizzaCraft;
import com.tiviacz.pizzacraft.recipes.chopping.ChoppingRecipe;
import com.tiviacz.pizzacraft.recipes.chopping.ChoppingRecipeSerializer;
import com.tiviacz.pizzacraft.recipes.crushing.CrushingRecipe;
import com.tiviacz.pizzacraft.recipes.crushing.CrushingRecipeSerializer;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PizzaCraft.MODID);

    public static final RegistryObject<RecipeSerializer<?>> CHOPPING_RECIPE_SERIALIZER = SERIALIZERS.register(ChoppingRecipeSerializer.ID.getPath(), () -> ChoppingRecipeSerializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<?>> CRUSHING_RECIPE_SERIALIZER = SERIALIZERS.register(CrushingRecipeSerializer.ID.getPath(), () -> CrushingRecipeSerializer.INSTANCE);


    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE.key(), PizzaCraft.MODID);

    public static final RegistryObject<RecipeType<ChoppingRecipe>> CHOPPING_RECIPE_TYPE = RECIPE_TYPES.register(ChoppingRecipe.Type.ID, () -> ChoppingRecipe.Type.CHOPPING_BOARD_RECIPE_TYPE);
    public static final RegistryObject<RecipeType<CrushingRecipe>> CRUSHING_RECIPE_TYPE = RECIPE_TYPES.register(CrushingRecipe.Type.ID, () -> CrushingRecipe.Type.CRUSHING_RECIPE_TYPE);
}
