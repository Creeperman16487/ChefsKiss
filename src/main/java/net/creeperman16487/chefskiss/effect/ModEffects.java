package net.creeperman16487.chefskiss.effect;

import net.creeperman16487.chefskiss.ChefskissMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ChefskissMod.MOD_ID);

    public static final RegistryObject<MobEffect> TRANQ_EFFECT = MOB_EFFECTS.register("tranq",
            () -> new TranqEffect(MobEffectCategory.HARMFUL,0xff00d9));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
