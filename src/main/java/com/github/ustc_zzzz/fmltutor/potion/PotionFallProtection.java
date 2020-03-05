package com.github.ustc_zzzz.fmltutor.potion;

import com.github.ustc_zzzz.fmltutor.FMLTutor;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/4
 * @Time:16:56
 * @Description:掉落保护药水
 */
public class PotionFallProtection extends Potion {

    private static final ResourceLocation res = new ResourceLocation(FMLTutor.MODID + ":" + "textures/gui/potion.png");

    public PotionFallProtection()
    {
        /**
         * 参数一：药水效果的名称
         * 参数二：这个附魔是否有害
         * 参数三：这个附魔的粒子效果颜色，这里定为深红色
         */
        super(new ResourceLocation(FMLTutor.MODID + ":" + "fall_protection"), false, 0x7F0000);
        //该方法与附魔的setName方法以及方块、物品等的setUnlocalizedName方法类似
        this.setPotionName("potion.fallProtection");
        //表示这个药水效果在显示的时候使用的图标在这种图（assets.minecraft.textures.gui.container.inventory.png）中的位置，两个参数表示x和y坐标
        this.setIconIndex(0, 0);
    }
}
