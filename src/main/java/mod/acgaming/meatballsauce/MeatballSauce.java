package mod.acgaming.meatballsauce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = MeatballSauce.MODID, name = MeatballSauce.NAME, version = MeatballSauce.VERSION, dependencies = MeatballSauce.DEPENDENCIES)
public class MeatballSauce
{
    public static final String MODID = "meatballsauce";
    public static final String NAME = "MeatballSauce";
    public static final String VERSION = "1.12.2-1.0.0";
    public static final String DEPENDENCIES = "required-after:mixinbooter;required-after:astralsorcery;required-after:botania";
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LOGGER.info(NAME + " applied");
    }
}