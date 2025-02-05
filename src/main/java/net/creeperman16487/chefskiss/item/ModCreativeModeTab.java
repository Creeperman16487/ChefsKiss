package net.creeperman16487.chefskiss.item;

import net.creeperman16487.chefskiss.ChefskissMod;
import net.creeperman16487.chefskiss.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChefskissMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHEFS_KISS_TAB = CREATIVE_MODE_TABS.register("chefs_kiss_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> ModItems.PIZZA.get().getDefaultInstance())
                    .title(Component.translatable("creativetab.chefs_kiss.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PIZZA.get());
                        output.accept(ModBlocks.PIZZA_OVEN.get());
                        output.accept(ModItems.DOUGH.get());
                        output.accept(ModItems.COOOKED_PIZZA.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
