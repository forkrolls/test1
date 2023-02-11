package com.forkrolls.isekaimod.block;

import com.forkrolls.isekaimod.IsekaiMod;
import com.forkrolls.isekaimod.block.custom.InterminableInterdimensionalCouloir;
import com.forkrolls.isekaimod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, IsekaiMod.MOD_ID);

    public static final RegistryObject<Block> LIFE_ESSENCE_BLOCK = registerBlock("life_essence_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AMONG_US_ORE = registerBlock("among_us_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(10,20)));
    public static final RegistryObject<Block> DEEPSLATE_AMONG_US_ORE = registerBlock("deepslate_among_us_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(10,20)));
    public static final RegistryObject<Block> NETHERRACK_AMONG_US_ORE = registerBlock("netherrack_among_us_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(10,20)));
    public static final RegistryObject<Block> ENDSTONE_AMONG_US_ORE = registerBlock("endstone_among_us_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(10,20)));

    public static final RegistryObject<Block> INTERMINABLE_INTERDIMENSIONAL_COULOIR = registerBlock("interminable_interdimensional_couloir",
            () -> new InterminableInterdimensionalCouloir(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(10,20)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
