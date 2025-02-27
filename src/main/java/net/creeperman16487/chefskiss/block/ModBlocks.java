package net.creeperman16487.chefskiss.block;

import net.creeperman16487.chefskiss.ChefskissMod;
import net.creeperman16487.chefskiss.block.custom.PizzaBlock;
import net.creeperman16487.chefskiss.item.ModItems;
import net.minecraft.world.level.block.Block;
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
            () -> new PizzaBlock(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .noParticlesOnBreak()
                    .instabreak()));



// This one registers a block and fires the function to register the item
    //THIS IS FOR DEFAULT BLOCKS ONLY
    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> Block) {
        RegistryObject<Block> block = BLOCKS.register(name, Block);
        ModItems.registerBlockItem(name, block); //register the item
        return block;
    }
//register in event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
