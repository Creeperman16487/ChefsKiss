package net.creeperman16487.chefskiss.effect;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TranqEffect extends MobEffect {
    public TranqEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof Player) {
            super.applyEffectTick(pLivingEntity, pAmplifier);
            return;
        }
        //pLivingEntity.canUpdate(false);
        //pLivingEntity.setDeltaMovement(0,0,0);
        //pLivingEntity.setYHeadRot(0f);
        //pLivingEntity.setYBodyRot(0f);
        //pLivingEntity.setXRot(0f);
        //pLivingEntity.setYRot(0f);
        pLivingEntity.getPersistentData().putBoolean("OriginalNoAI",false);
        pLivingEntity.sendSystemMessage(Component.literal("HII"));
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @SubscribeEvent
    public void onEffectAdded(MobEffectEvent.Added event) {
        if (event.getEffectInstance().getEffect() == this && event.getEntity() instanceof Mob mob) {
            mob.getPersistentData().putBoolean("OriginalNoAI", mob.isNoAi()); // Store original state
            mob.setNoAi(true); // Disable AI
        }
    }

    @SubscribeEvent
    public void onEffectRemoved(MobEffectEvent.Remove event) {
        if (event.getEffect() == this && event.getEntity() instanceof Mob mob) {
            mob.setNoAi(mob.getPersistentData().getBoolean("OriginalNoAI")); // Restore original state
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
