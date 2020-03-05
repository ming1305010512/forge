package com.github.ustc_zzzz.fmltutor.creativetab;

import com.github.ustc_zzzz.fmltutor.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:18:56
 * @Description:新建一个创造模式物品栏
 */
public class CreativeTabsFMLTutor extends CreativeTabs {

    public CreativeTabsFMLTutor() {
        super("fmltutor");
        //设置创造模式物品栏的背景
        this.setBackgroundImageName("fmltutor.png");
    }

    /**
     * 返回创造模式物品栏上显示的物品
     * @return
     */
    @Override
    public Item getTabIconItem() {
        return ItemLoader.goldenEgg;
    }

    /**
     * 用于设置是否有搜索框
     * @return
     */
    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
