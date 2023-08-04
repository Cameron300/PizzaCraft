package com.tiviacz.pizzacraft.init;

import com.tiviacz.pizzacraft.PizzaCraft;
import com.tiviacz.pizzacraft.blocks.*;
import com.tiviacz.pizzacraft.blocks.crops.DoubleCropBlock;
import com.tiviacz.pizzacraft.blocks.crops.SimpleCropBlock;
import com.tiviacz.pizzacraft.worldgen.trees.OliveTree;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PizzaCraft.MODID);

    public static final RegistryObject<Block> PIZZA = registerBlock("pizza", () -> new PizzaBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> RAW_PIZZA = registerBlock("raw_pizza", () -> new RawPizzaBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> DOUGH = registerBlock("dough", () -> new DoughBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> CHEESE_BLOCK = registerBlock("cheese_block", () -> new CheeseBlock(Block.Properties.of(Material.CAKE, MaterialColor.COLOR_YELLOW).strength(0.5F).sound(SoundType.FUNGUS)));
    public static final RegistryObject<Block> PIZZA_STATION = registerBlock("pizza_station", () -> new PizzaStationBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> OVEN = registerBlock("oven", () -> new OvenBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).noOcclusion().lightLevel(getLightValueLit(9))));

    //Gear
    public static final RegistryObject<Block> RED_PIZZA_BAG = registerBlock("red_pizza_bag", () -> new PizzaBagBlock(Block.Properties.copy(Blocks.RED_WOOL)));

    //Basins
    public static final RegistryObject<Block> GRANITE_BASIN = registerBlock("granite_basin", () -> new BasinBlock(Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> DIORITE_BASIN = registerBlock("diorite_basin", () -> new BasinBlock(Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANDESITE_BASIN = registerBlock("andesite_basin", () -> new BasinBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> BASALT_BASIN = registerBlock("basalt_basin", () -> new BasinBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> BLACKSTONE_BASIN = registerBlock("blackstone_basin", () -> new BasinBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.5F, 6.0F)));

    //Chopping Boards
    public static final RegistryObject<Block> OAK_CHOPPING_BOARD = registerBlock("oak_chopping_board", () -> new ChoppingBoardBlock(Block.Properties.copy(Blocks.OAK_PLANKS)));           ///.of(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD))); //new ChoppingBoardBlock(Block.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> BIRCH_CHOPPING_BOARD = registerBlock("birch_chopping_board", () -> new ChoppingBoardBlock(Block.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_CHOPPING_BOARD = registerBlock("spruce_chopping_board", () -> new ChoppingBoardBlock(Block.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_CHOPPING_BOARD = registerBlock("jungle_chopping_board", () -> new ChoppingBoardBlock(Block.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> ACACIA_CHOPPING_BOARD = registerBlock("acacia_chopping_board", () -> new ChoppingBoardBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_CHOPPING_BOARD = registerBlock("dark_oak_chopping_board", () -> new ChoppingBoardBlock(Block.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> CRIMSON_CHOPPING_BOARD = registerBlock("crimson_chopping_board", () -> new ChoppingBoardBlock(Block.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> WARPED_CHOPPING_BOARD = registerBlock("warped_chopping_board", () -> new ChoppingBoardBlock(Block.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> OLIVE_CHOPPING_BOARD = registerBlock("olive_chopping_board", () -> new ChoppingBoardBlock(Block.Properties.copy(Blocks.OAK_PLANKS)));

    //Trees
    public static final RegistryObject<Block> OLIVE_PLANKS = registerBlock("olive_planks", () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> OLIVE_SAPLING = registerBlock("olive_sapling", () -> new SaplingBlock(new OliveTree(), Block.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> OLIVE_LOG = registerOliveLogBlock("olive_log", MaterialColor.WOOD, MaterialColor.TERRACOTTA_LIGHT_GRAY);
    public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = registerOliveLogBlock("stripped_olive_log", MaterialColor.WOOD, MaterialColor.WOOD);
    public static final RegistryObject<Block> STRIPPED_OLIVE_WOOD = registerBlock("stripped_olive_wood", () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> OLIVE_WOOD = registerBlock("olive_wood", () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> OLIVE_LEAVES = registerBlock("olive_leaves", () -> new LeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> FRUIT_OLIVE_LEAVES = registerBlock("fruit_olive_leaves", () -> new OliveLeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> OLIVE_SLAB = registerBlock("olive_slab", () -> new SlabBlock(Block.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> OLIVE_PRESSURE_PLATE = registerBlock("olive_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<Block> OLIVE_FENCE = registerBlock("olive_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OLIVE_TRAPDOOR = registerBlock("olive_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<Block> OLIVE_FENCE_GATE = registerBlock("olive_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE)));
    public static final RegistryObject<Block> OLIVE_BUTTON = registerBlock("olive_button", () -> new WoodButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> OLIVE_STAIRS = registerBlock("olive_stairs", () -> new StairBlock(() -> OLIVE_PLANKS.get().defaultBlockState(), Block.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> OLIVE_DOOR = registerBlock("olive_door", () -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> OLIVE_BOOKSHELF = registerBlock("olive_bookshelf", () -> new OliveBookshelfBlock(Block.Properties.copy(Blocks.BOOKSHELF)));

    //Crops
    public static final RegistryObject<Block> BROCCOLI = registerBlock("broccoli", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), () -> ModItems.BROCCOLI_SEEDS.get()));
    public static final RegistryObject<Block> CORNS = registerBlock("corns", () -> new DoubleCropBlock(Block.Properties.copy(Blocks.WHEAT), () -> ModItems.CORN.get()));
    public static final RegistryObject<Block> CUCUMBERS = registerBlock("cucumbers", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), () -> ModItems.CUCUMBER_SEEDS.get()));
    public static final RegistryObject<Block> ONIONS = registerBlock("onions", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), () -> ModItems.ONION.get()));
    public static final RegistryObject<Block> PEPPERS = registerBlock("peppers", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), () -> ModItems.PEPPER_SEEDS.get()));
    public static final RegistryObject<Block> PINEAPPLE = registerBlock("pineapple", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), () -> ModItems.PINEAPPLE_SEEDS.get()));
    public static final RegistryObject<Block> TOMATOES = registerBlock("tomatoes", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), () -> ModItems.TOMATO_SEEDS.get()));

    public static Block[] getChoppingBoards()
    {
        return new Block[] {
                OAK_CHOPPING_BOARD.get(),
                BIRCH_CHOPPING_BOARD.get(),
                SPRUCE_CHOPPING_BOARD.get(),
                JUNGLE_CHOPPING_BOARD.get(),
                ACACIA_CHOPPING_BOARD.get(),
                DARK_OAK_CHOPPING_BOARD.get(),
                CRIMSON_CHOPPING_BOARD.get(),
                WARPED_CHOPPING_BOARD.get()
        };
    }

    public static Block[] getBasins()
    {
        return new Block[] {
                GRANITE_BASIN.get(),
                DIORITE_BASIN.get(),
                ANDESITE_BASIN.get(),
                BASALT_BASIN.get(),
                BLACKSTONE_BASIN.get()
        };
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    public static RegistryObject<Block> registerBlock(final String name, Supplier<Block> block)
    {
        return BLOCKS.register(name, block);
    }

    private static RegistryObject<Block> registerOliveLogBlock(final String name, MaterialColor topColor, MaterialColor barkColor)
    {
        return BLOCKS.register(name, () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD, (state) ->
                state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).strength(2.0F).sound(SoundType.WOOD)));
    }
}