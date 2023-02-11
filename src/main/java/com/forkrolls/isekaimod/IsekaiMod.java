package com.forkrolls.isekaimod;

import com.forkrolls.isekaimod.block.ModBlocks;
import com.mojang.logging.LogUtils;
import com.forkrolls.isekaimod.item.ModCreativeModeTabs;
import com.forkrolls.isekaimod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IsekaiMod.MOD_ID)
public class IsekaiMod {
    public static final String MOD_ID = "isekaimod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public IsekaiMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.URANIUM);
            event.accept(ModItems.RAW_URANIUM);
        }

        if(event.getTab() == ModCreativeModeTabs.SCIENCE_TAB){
            event.accept(ModItems.URANIUM);
            event.accept(ModItems.RAW_URANIUM);
            event.accept(ModItems.DICE);
        }

        if(event.getTab() == ModCreativeModeTabs.MAGIC_TAB){
            event.accept(ModBlocks.LIFE_ESSENCE_BLOCK);
            event.accept(ModBlocks.AMONG_US_ORE);
            event.accept(ModBlocks.DEEPSLATE_AMONG_US_ORE);
            event.accept(ModBlocks.NETHERRACK_AMONG_US_ORE);
            event.accept(ModBlocks.ENDSTONE_AMONG_US_ORE);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
