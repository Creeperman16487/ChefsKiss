package net.creeperman16487.chefskiss.block;

import net.creeperman16487.chefskiss.ChefskissMod;
import net.creeperman16487.chefskiss.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ChefskissMod.MOD_ID);

    public static final RegistryObject<Block> PIZZA_OVEN = registerBlock("pizza_oven",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("pizza_oven"))
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

// This one registers a block and fires the second function
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
// The second function registers a block item so its visible in inventory
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties()
                .setId(ModItems.ITEMS.key(name))));
    }
//register in event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
