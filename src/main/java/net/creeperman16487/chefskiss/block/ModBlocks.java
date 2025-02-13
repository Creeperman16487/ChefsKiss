package net.creeperman16487.chefskiss.block;

import net.creeperman16487.chefskiss.ChefskissMod;
import net.creeperman16487.chefskiss.item.ModItems;
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

    public static final RegistryObject<Block> PIZZA_BLOCK = registerBlock("pizza_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

// This one registers a block and fires the function to register the item
    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, block);
        ModItems.registerBlockItem(name, toReturn); //register the item
        return toReturn;
    }
//register in event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
