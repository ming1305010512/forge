package com.github.ustc_zzzz.fmltutor.common;

import com.github.ustc_zzzz.fmltutor.block.BlockGrassBlock;
import com.github.ustc_zzzz.fmltutor.block.BlockLoader;
import com.github.ustc_zzzz.fmltutor.crafting.CraftingLoader;
import com.github.ustc_zzzz.fmltutor.creativetab.CreativeTabsLoader;
import com.github.ustc_zzzz.fmltutor.enchantment.EnchantmentLoader;
import com.github.ustc_zzzz.fmltutor.item.ItemLoader;
import com.github.ustc_zzzz.fmltutor.potion.PotionLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:16:14
 * @Description：公共代理类
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){

        //注册配置文件
        new ConfigLoader(event);
        //初始化新建的创造模式物品栏
        new CreativeTabsLoader(event);
        //实例化并注册物品
        new ItemLoader(event);
        //实例化并注册方块
        new BlockLoader(event);
        //实例化药水效果
        new PotionLoader(event);
    }

    public void init(FMLInitializationEvent event){
        //加载合成表，烧炼规则和燃料
        new CraftingLoader();
        //附魔加载
        new EnchantmentLoader();
        //注册事件
        new EventLoader();
    }

    public void postInit(FMLPostInitializationEvent event){

    }

}
