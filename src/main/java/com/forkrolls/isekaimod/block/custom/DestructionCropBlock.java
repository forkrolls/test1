package com.forkrolls.isekaimod.block.custom;

import com.forkrolls.isekaimod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class DestructionCropBlock extends CropBlock {

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0,4);

    public DestructionCropBlock(Properties properties, UniformInt of) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.DESTRUCTION_SEEDS.get();
    }

    @Override
    public IntegerProperty getAgeProperty(){
        return AGE;
    }

    @Override
    public int getMaxAge(){
        return 4;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
