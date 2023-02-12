package com.forkrolls.isekaimod.item;

import com.forkrolls.isekaimod.IsekaiMod;
import com.forkrolls.isekaimod.item.custom.DiceItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IsekaiMod.MOD_ID);

    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DICE = ITEMS.register("dice",
            () -> new DiceItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DESTRUCTION_SEEDS = ITEMS.register("destruction_seeds",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DESTRUCTION_FRUIT = ITEMS.register("destruction_fruit",
            () -> new Item(new Item.Properties().stacksTo(16)
                    .food(new FoodProperties.Builder().nutrition(5).build())));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
