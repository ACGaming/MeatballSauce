package mod.acgaming.meatballsauce.mixin.astralsorcery;

import hellfirepvp.astralsorcery.common.integrations.mods.crafttweaker.tweaks.GameStageTweaks;
import mod.acgaming.meatballsauce.MeatballSauce;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GameStageTweaks.class, remap = false)
public class GameStageTweaksMixin
{
    @Inject(method = "addLevelCap", at = @At("HEAD"))
    private static void msAddLevelCap(String stageName, int levelCap, CallbackInfo ci)
    {
        stageName = stageName.toLowerCase();
        MeatballSauce.LOGGER.info("Modified stage name to: {}", stageName);
    }
}