package com.github.ustc_zzzz.fmltutor.client;

import com.github.ustc_zzzz.fmltutor.common.CommonProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:16:17
 * @Description:客户端代理类
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        new ItemRenderLoader();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
