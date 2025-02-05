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
                    .setId(ITEMS.key("pizza"))
                    .fireResistant()));

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item) {
        return ModItems.ITEMS.register(name,item);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
