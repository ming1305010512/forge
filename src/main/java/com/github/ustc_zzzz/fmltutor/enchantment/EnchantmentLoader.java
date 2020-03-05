package com.github.ustc_zzzz.fmltutor.enchantment;

import com.github.ustc_zzzz.fmltutor.common.ConfigLoader;
import net.minecraft.enchantment.Enchantment;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/3
 * @Time:20:03
 * @Description：附魔加载类
 */
public class EnchantmentLoader {

    public static Enchantment fireBurn;

    public EnchantmentLoader() {
        try {
            fireBurn = new EnchantmentFireBurn();
            //将附魔进行注册
            Enchantment.addToBookList(fireBurn);
        } catch (Exception e) {
            ConfigLoader.logger().error(
                    "Duplicate or illegal enchantment id: {}, the registry of class '{}' will be skipped. ",
                    ConfigLoader.enchantmentFireBurn, EnchantmentFireBurn.class.getName());
        }
    }
}
