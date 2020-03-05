package com.github.ustc_zzzz.fmltutor.potion;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/4
 * @Time:16:55
 * @Descriotion:药水加载类
 */
public class PotionLoader {

    public static Potion potionFallProtection;

    public PotionLoader(FMLPreInitializationEvent event) {
        potionFallProtection = new PotionFallProtection();
    }
}
