package mod.acgaming.meatballsauce;

import java.util.ArrayList;
import java.util.List;

import zone.rong.mixinbooter.ILateMixinLoader;

public class MSMixinLoader implements ILateMixinLoader
{
    @Override
    public List<String> getMixinConfigs()
    {
        List<String> mixins = new ArrayList<>();
        mixins.add("meatballsauce.mixins.json");
        return mixins;
    }
}