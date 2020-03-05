package com.github.ustc_zzzz.fmltutor.item;

import com.github.ustc_zzzz.fmltutor.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/3
 * @Time:11:08
 * @Description:红石稿
 */
public class ItemRedstonePickaxe extends ItemPickaxe {

    /**
     * EnumHelper的作用就是为Minecraft的一些枚举类型注册新的实例
     */
    public static final Item.ToolMaterial REDSTONE = EnumHelper.addToolMaterial("REDSTONE", 3, 16, 16.0F, 0.0F, 10);
    protected ItemRedstonePickaxe() {
        super(REDSTONE);
        this.setUnlocalizedName("redstonePickaxe");
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
    }
}
