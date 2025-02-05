package net.creeperman16487.chefskiss.item;

import net.creeperman16487.chefskiss.ChefskissMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChefskissMod.MOD_ID);

    public static final RegistryObject<Item> PIZZA = ITEMS.register("pizza",
            () -> new Item(new Item.Properties().setId(ITEMS.key("pizza"))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
