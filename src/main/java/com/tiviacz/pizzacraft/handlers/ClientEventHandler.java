package com.tiviacz.pizzacraft.handlers;

import com.tiviacz.pizzacraft.PizzaCraft;
import com.tiviacz.pizzacraft.client.DynamicPizzaSliceModel;
import com.tiviacz.pizzacraft.client.LayerSelector;
import com.tiviacz.pizzacraft.client.PizzaBakedModel;
import com.tiviacz.pizzacraft.client.gui.ScreenPizzaStation;
import com.tiviacz.pizzacraft.client.renderer.BasinRenderer;
import com.tiviacz.pizzacraft.client.renderer.ChefHatModel;
import com.tiviacz.pizzacraft.client.renderer.PizzaDeliveryCapModel;
import com.tiviacz.pizzacraft.init.ModBlocks;
import com.tiviacz.pizzacraft.init.PizzaLayers;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PizzaCraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventHandler
{
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        ModelLoaderRegistry.registerLoader(new ResourceLocation(PizzaCraft.MODID, "pizza_slice_loader"), DynamicPizzaSliceModel.Loader.INSTANCE);
    }

    @SubscribeEvent
    public static void layerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(BasinRenderer.ContentModel.CONTENT_LAYER, BasinRenderer.ContentModel::createModelData);
        event.registerLayerDefinition(BasinRenderer.SauceModel.SAUCE_LAYER, BasinRenderer.SauceModel::createModelData);
        event.registerLayerDefinition(PizzaDeliveryCapModel.CAP, PizzaDeliveryCapModel::createModelData);
        event.registerLayerDefinition(ChefHatModel.CHEF_HAT, ChefHatModel::createModelData);
    }

    @SubscribeEvent
    public static void onModelBakeEvent(ModelBakeEvent event)
    {
        for(BlockState blockState : ModBlocks.PIZZA.get().getStateDefinition().getPossibleStates())
        {
            ModelResourceLocation variantMRL = BlockModelShaper.stateToModelLocation(blockState);
            BakedModel existingModel = event.getModelRegistry().get(variantMRL);
            if(existingModel == null)
            {
                //LOGGER.warn("Did not find the expected vanilla baked model(s) for blockAltimeter in registry");
            }
            else if(existingModel instanceof PizzaBakedModel)
            {
               // LOGGER.warn("Tried to replace AltimeterBakedModel twice");
            }
            else
            {
                PizzaBakedModel customModel = new PizzaBakedModel(existingModel);
                event.getModelRegistry().put(variantMRL, customModel);
            }
        }

        for(BlockState blockState : ModBlocks.RAW_PIZZA.get().getStateDefinition().getPossibleStates())
        {
            ModelResourceLocation variantMRL = BlockModelShaper.stateToModelLocation(blockState);
            BakedModel existingModel = event.getModelRegistry().get(variantMRL);
            if(existingModel == null)
            {
                //LOGGER.warn("Did not find the expected vanilla baked model(s) for blockAltimeter in registry");
            }
            else if(existingModel instanceof PizzaBakedModel)
            {
                // LOGGER.warn("Tried to replace AltimeterBakedModel twice");
            }
            else
            {
                PizzaBakedModel customModel = new PizzaBakedModel(existingModel);
                event.getModelRegistry().put(variantMRL, customModel);
            }
        }
    }

    @SubscribeEvent
    public static void stitcherEventPre(TextureStitchEvent.Pre event)
    {
        if(event.getAtlas().location() == InventoryMenu.BLOCK_ATLAS)
        {
            event.addSprite(PizzaLayers.PIZZA_SLICE);

            //Base
            event.addSprite(PizzaLayers.CHEESE_LAYER);
            event.addSprite(PizzaLayers.RAW_CHEESE_LAYER);

            //Vegetables
            event.addSprite(PizzaLayers.BROCCOLI_LAYER);
            event.addSprite(PizzaLayers.CORN_LAYER);
            event.addSprite(PizzaLayers.CUCUMBER_LAYER);
            event.addSprite(PizzaLayers.ONION_LAYER);
            event.addSprite(PizzaLayers.PEPPER_LAYER);
            event.addSprite(PizzaLayers.TOMATO_LAYER);

            event.addSprite(PizzaLayers.RAW_BROCCOLI_LAYER);
            event.addSprite(PizzaLayers.RAW_CORN_LAYER);
            event.addSprite(PizzaLayers.RAW_CUCUMBER_LAYER);
            event.addSprite(PizzaLayers.RAW_ONION_LAYER);
            event.addSprite(PizzaLayers.RAW_PEPPER_LAYER);
            event.addSprite(PizzaLayers.RAW_TOMATO_LAYER);

            event.addSprite(PizzaLayers.BROCCOLI_ITEM_LAYER);
            event.addSprite(PizzaLayers.CORN_ITEM_LAYER);
            event.addSprite(PizzaLayers.CUCUMBER_ITEM_LAYER);
            event.addSprite(PizzaLayers.ONION_ITEM_LAYER);
            event.addSprite(PizzaLayers.PEPPER_ITEM_LAYER);
            event.addSprite(PizzaLayers.TOMATO_ITEM_LAYER);

            //Fruits
            event.addSprite(PizzaLayers.PINEAPPLE_LAYER);
            event.addSprite(PizzaLayers.OLIVE_LAYER);

            event.addSprite(PizzaLayers.RAW_PINEAPPLE_LAYER);
            event.addSprite(PizzaLayers.RAW_OLIVE_LAYER);

            event.addSprite(PizzaLayers.PINEAPPLE_ITEM_LAYER);
            event.addSprite(PizzaLayers.OLIVE_ITEM_LAYER);

            //Mushrooms
            event.addSprite(PizzaLayers.MUSHROOM_LAYER);

            event.addSprite(PizzaLayers.RAW_MUSHROOM_LAYER);

            event.addSprite(PizzaLayers.MUSHROOM_ITEM_LAYER);

            //Meats
            event.addSprite(PizzaLayers.HAM_LAYER);
            event.addSprite(PizzaLayers.BEEF_LAYER);
            event.addSprite(PizzaLayers.CHICKEN_LAYER);

            event.addSprite(PizzaLayers.RAW_HAM_LAYER);
            event.addSprite(PizzaLayers.RAW_BEEF_LAYER);
            event.addSprite(PizzaLayers.RAW_CHICKEN_LAYER);

            event.addSprite(PizzaLayers.HAM_ITEM_LAYER);
            event.addSprite(PizzaLayers.BEEF_ITEM_LAYER);
            event.addSprite(PizzaLayers.CHICKEN_ITEM_LAYER);

            //Sauces
            event.addSprite(PizzaLayers.TOMATO_SAUCE_LAYER);
            event.addSprite(PizzaLayers.TOMATO_SAUCE_ITEM_LAYER);
            event.addSprite(PizzaLayers.HOT_SAUCE_LAYER);
            event.addSprite(PizzaLayers.HOT_SAUCE_ITEM_LAYER);

            //Universal
            event.addSprite(LayerSelector.RAW_BROCCOLI_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.RAW_CORN_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.RAW_CUCUMBER_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.RAW_ONION_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.RAW_PEPPER_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.RAW_TOMATO_UNIVERSAL_LAYER);

            event.addSprite(LayerSelector.RAW_PINEAPPLE_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.RAW_OLIVE_UNIVERSAL_LAYER);

            event.addSprite(LayerSelector.RAW_MUSHROOM_UNIVERSAL_LAYER);

            event.addSprite(LayerSelector.RAW_HAM_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.RAW_BEEF_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.RAW_CHICKEN_UNIVERSAL_LAYER);

            //Item Universal
            event.addSprite(LayerSelector.BROCCOLI_ITEM_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.CORN_ITEM_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.CUCUMBER_ITEM_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.ONION_ITEM_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.PEPPER_ITEM_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.TOMATO_ITEM_UNIVERSAL_LAYER);

            event.addSprite(LayerSelector.PINEAPPLE_ITEM_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.OLIVE_ITEM_UNIVERSAL_LAYER);

            event.addSprite(LayerSelector.MUSHROOM_ITEM_UNIVERSAL_LAYER);

            event.addSprite(LayerSelector.HAM_ITEM_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.BEEF_ITEM_UNIVERSAL_LAYER);
            event.addSprite(LayerSelector.CHICKEN_ITEM_UNIVERSAL_LAYER);

            //Icons
            for(ResourceLocation res : ScreenPizzaStation.DOUGH)
            {
                event.addSprite(res);
            }

            for(ResourceLocation res : ScreenPizzaStation.SAUCES)
            {
                event.addSprite(res);
            }
        }
    }
}