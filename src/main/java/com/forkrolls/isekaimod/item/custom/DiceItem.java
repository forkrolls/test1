package com.forkrolls.isekaimod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class DiceItem extends Item {
    public DiceItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            //random num
            outputRandomNumber(player);
            //cooldown set
            player.getCooldowns().addCooldown(this, 20);
        }


        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            list.add(Component.literal("tra valo").withStyle(ChatFormatting.BOLD));
        }else{
            list.add(Component.literal("Press SHIFT to instantly play valo").withStyle(ChatFormatting.LIGHT_PURPLE));
        }

        super.appendHoverText(stack, level, list, flag);
    }

    private void outputRandomNumber(Player player){
        player.sendSystemMessage(Component.literal("The Imposter is" + getRandomNumber()));
    }

    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
