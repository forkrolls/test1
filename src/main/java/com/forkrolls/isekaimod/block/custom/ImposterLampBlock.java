package com.forkrolls.isekaimod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ImposterLampBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    public ImposterLampBlock(Properties properties, UniformInt of) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand interactionHand, BlockHitResult result) {
        if(!level.isClientSide() && interactionHand == InteractionHand.MAIN_HAND){
            level.setBlock(pos, state.cycle(LIT),3);
        }

        return super.use(state, level, pos, player, interactionHand, result);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
}
