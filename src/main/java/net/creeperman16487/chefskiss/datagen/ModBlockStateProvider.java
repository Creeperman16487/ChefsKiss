package net.creeperman16487.chefskiss.datagen;


import net.creeperman16487.chefskiss.ChefskissMod;
import net.creeperman16487.chefskiss.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    private ExistingFileHelper existingFileHelper;
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChefskissMod.MOD_ID, exFileHelper);
        existingFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.PIZZA_BLOCK.get(),new ModelFile.ExistingModelFile(new ResourceLocation("block/pizza_block"),existingFileHelper));
    }
}
