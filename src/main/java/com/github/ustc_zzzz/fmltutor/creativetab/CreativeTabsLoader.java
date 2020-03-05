package com.github.ustc_zzzz.fmltutor.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:19:01
 * @Description:实例化创建模式物品栏
 */
public class CreativeTabsLoader {

    public static CreativeTabs tabFMLTutor;

    public CreativeTabsLoader(FMLPreInitializationEvent event) {
        tabFMLTutor = new CreativeTabsFMLTutor();
    }
}
