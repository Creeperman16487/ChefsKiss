package net.creeperman16487.chefskiss.item;

import net.creeperman16487.chefskiss.ChefskissMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChefskissMod.MOD_ID);

    public static final RegistryObject<Item> PIZZA = registerItem("pizza",
            () -> new Item(new Item.Properties()
                    .fireResistant()
                    .stacksTo(1)
                    .food(ModFoods.PIZZA)));

    public static final RegistryObject<Item> COOKED_PIZZA = registerItem("cooked_pizza",
            () -> new Item(new Item.Properties()
                    .fireResistant()
                    .stacksTo(1)
                    .food(ModFoods.COOKED_PIZZA)));

    public static final RegistryObject<Item> DOUGH = registerItem("dough",
            () -> new Item(new Item.Properties()
                    .fireResistant()
                    .stacksTo(1)
                    .food(ModFoods.DOUGH)));
//REGISTER ITEM METHOD
    private static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
        return ModItems.ITEMS.register(name,item);
    }
    //register block item
    public static void registerBlockItem(String name, RegistryObject<Block> block) {
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties()));
    }
//register in event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
