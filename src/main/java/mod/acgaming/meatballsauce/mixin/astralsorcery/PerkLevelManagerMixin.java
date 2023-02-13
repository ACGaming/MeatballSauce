package mod.acgaming.meatballsauce.mixin.astralsorcery;

import hellfirepvp.astralsorcery.common.constellation.perk.PerkLevelManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = PerkLevelManager.class, remap = false)
public class PerkLevelManagerMixin
{
    @Redirect(method = "ensureLevels", at = @At(value = "FIELD", target = "Lhellfirepvp/astralsorcery/common/constellation/perk/PerkLevelManager;LEVEL_CAP:I"))
    public int msEnsureLevels()
    {
        return 100;
    }
}