package mod.acgaming.meatballsauce.mixin.botania;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import vazkii.botania.client.render.world.SkyblockRenderEvents;

@Mixin(value = SkyblockRenderEvents.class, remap = false)
public class SkyblockRenderEventsMixin
{
    @ModifyConstant(method = "onRender", constant = @Constant(intValue = 0))
    private static int msOnRender(int constant)
    {
        return 43;
    }
}