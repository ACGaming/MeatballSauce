package mod.acgaming.meatballsauce.mixin.botania;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import mod.acgaming.meatballsauce.MeatballSauce;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.client.render.world.SkyblockRenderEvents;
import vazkii.botania.client.render.world.SkyblockSkyRenderer;
import vazkii.botania.common.core.handler.ConfigHandler;

@Mixin(value = SkyblockRenderEvents.class, remap = false)
public class SkyblockRenderEventsMixin
{
    @Inject(method = "onRender", at = @At(value = "HEAD"), cancellable = true)
    private static void msOnRender(RenderWorldLastEvent event, CallbackInfo ci)
    {
        World world = Minecraft.getMinecraft().world;
        if (ConfigHandler.enableFancySkybox && ConfigHandler.enableFancySkyboxInNormalWorlds && world.provider.getDimension() == 43 && !(world.provider.getSkyRenderer() instanceof SkyblockSkyRenderer))
        {
            world.provider.setSkyRenderer(new SkyblockSkyRenderer());
            MeatballSauce.LOGGER.debug("Enabled fancy skybox for dimension 43");
        }
        ci.cancel();
    }
}