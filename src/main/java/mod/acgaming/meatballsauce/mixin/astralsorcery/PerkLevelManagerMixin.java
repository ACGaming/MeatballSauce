package mod.acgaming.meatballsauce.mixin.astralsorcery;

import net.minecraft.entity.player.EntityPlayer;

import hellfirepvp.astralsorcery.common.constellation.perk.PerkLevelManager;
import mod.acgaming.meatballsauce.MeatballSauce;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PerkLevelManager.class, remap = false)
public class PerkLevelManagerMixin
{
    @Inject(method = "resolveLevelCap", at = @At(value = "RETURN"))
    private static void msResolveLevelCap(EntityPlayer player, CallbackInfoReturnable<Integer> cir)
    {
        MeatballSauce.LOGGER.debug("Current perk level cap for {} is at level {}", player.getDisplayNameString(), cir.getReturnValue());
    }

    @Redirect(method = "ensureLevels", at = @At(value = "FIELD", target = "Lhellfirepvp/astralsorcery/common/constellation/perk/PerkLevelManager;LEVEL_CAP:I"))
    public int msEnsureLevels()
    {
        return 100;
    }
}