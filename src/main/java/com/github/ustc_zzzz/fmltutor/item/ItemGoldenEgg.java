package com.github.ustc_zzzz.fmltutor.item;

import com.github.ustc_zzzz.fmltutor.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:16:20
 * @Description: 创建一个物品（金蛋）
 */
public class ItemGoldenEgg extends Item {

    public ItemGoldenEgg()
    {
        super();
        this.setUnlocalizedName("goldenEgg");
        //将物品注册进新建的创造模式物品栏中
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
    }
}
