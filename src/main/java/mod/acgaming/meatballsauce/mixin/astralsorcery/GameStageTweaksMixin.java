package mod.acgaming.meatballsauce.mixin.astralsorcery;

import java.util.Map;

import hellfirepvp.astralsorcery.common.integrations.mods.crafttweaker.tweaks.GameStageTweaks;
import mod.acgaming.meatballsauce.MeatballSauce;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GameStageTweaks.class, remap = false)
public class GameStageTweaksMixin
{
    @Shadow
    private static Map<String, Integer> stageLevelCap;

    @Inject(method = "addLevelCap", at = @At("HEAD"), cancellable = true)
    private static void msAddLevelCap(String stageName, int levelCap, CallbackInfo ci)
    {
        stageLevelCap.put(stageName.toLowerCase(), levelCap);
        MeatballSauce.LOGGER.debug("Added stage name {} with perk level cap {}", stageName.toLowerCase(), levelCap);
        ci.cancel();
    }
}