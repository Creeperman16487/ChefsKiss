package net.creeperman16487.chefskiss.potion;

import net.creeperman16487.chefskiss.ChefskissMod;
import net.creeperman16487.chefskiss.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, ChefskissMod.MOD_ID);
    public static final RegistryObject<Potion> TRANQ_POTION = POTIONS.register("tranq_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.TRANQ_EFFECT.get(),400)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
