package com.github.ustc_zzzz.fmltutor;

import com.github.ustc_zzzz.fmltutor.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:15:55
 */
@Mod(modid = FMLTutor.MODID, name = FMLTutor.NAME, version = FMLTutor.VERSION, acceptedMinecraftVersions = "1.8.9")
public class FMLTutor {

    public static final String MODID = "fmltutor";
    public static final String NAME = "FML Tutor";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(FMLTutor.MODID)
    public static FMLTutor instance;

    @SidedProxy(clientSide = "com.github.ustc_zzzz.fmltutor.client.ClientProxy",
            serverSide = "com.github.ustc_zzzz.fmltutor.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
