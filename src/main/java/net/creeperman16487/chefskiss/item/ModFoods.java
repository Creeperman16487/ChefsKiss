package net.creeperman16487.chefskiss.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PIZZA = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.2f)
            .effect(
                    () -> new MobEffectInstance(MobEffects.CONFUSION,200),
                    .4f)
            .build();

    public static final FoodProperties COOKED_PIZZA = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.3f)
            .build();

    public static final FoodProperties DOUGH = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.2f)
            .effect(
                    () -> new MobEffectInstance(MobEffects.CONFUSION,200),
                    .4f)
            .build();
}
