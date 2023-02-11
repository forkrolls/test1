package com.forkrolls.isekai.item;

import com.forkrolls.isekai.IsekaiMod;
import com.forkrolls.isekai.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IsekaiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab MAGIC_TAB;
    public static CreativeModeTab SCIENCE_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        MAGIC_TAB = event.registerCreativeModeTab(new ResourceLocation(IsekaiMod.MOD_ID, "magic_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RAW_URANIUM.get()))
                        .title(Component.translatable("creativemodetab.magic_tab")));
        SCIENCE_TAB = event.registerCreativeModeTab(new ResourceLocation(IsekaiMod.MOD_ID, "science_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.AMONG_US_ORE.get()))
                        .title(Component.translatable("creativemodetab.science_tab")));
    }
}
