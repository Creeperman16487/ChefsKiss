package net.creeperman16487.chefskiss.datagen;

import net.creeperman16487.chefskiss.ChefskissMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ChefskissMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataProvider {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataProvider = event.getGenerator();
        PackOutput packOutput = dataProvider.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        dataProvider.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        dataProvider.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput,existingFileHelper));

        ModBlockTagProvider blockTagProvider = dataProvider.addProvider(event.includeServer(),
                new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
        dataProvider.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));
    }
}
