package net.creeperman16487.chefskiss.datagen;

import com.mojang.logging.LogUtils;
import net.creeperman16487.chefskiss.ChefskissMod;
import net.minecraft.core.HolderLookup;
import org.slf4j.Logger;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ChefskissMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        LOGGER.info("TAGS ADDING AHHH");
    }
}
