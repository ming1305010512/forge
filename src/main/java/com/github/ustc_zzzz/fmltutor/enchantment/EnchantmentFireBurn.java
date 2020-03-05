package com.github.ustc_zzzz.fmltutor.enchantment;

import com.github.ustc_zzzz.fmltutor.FMLTutor;
import com.github.ustc_zzzz.fmltutor.common.ConfigLoader;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/3
 * @Time:19:49
 * @Description:火焰附魔
 */
public class EnchantmentFireBurn extends Enchantment {

    protected EnchantmentFireBurn() {
        super(ConfigLoader.enchantmentFireBurn, new ResourceLocation(FMLTutor.MODID + ":" + "fire_burn"), 1,
                EnumEnchantmentType.DIGGER);
        //和方块物品等的setUnlocalizedName方法类似
        this.setName("fireBurn");
    }

    /**
     * 获取可以获取到此附魔的最低等级
     *
     * @param enchantmentLevel
     * @return
     */
    @Override
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 15;
    }

    /**
     * 获取可以获取到此附魔的最高等级
     * @param enchantmentLevel
     * @return
     */
    @Override
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    /**
     * 这个附魔的最大等级
     * @return
     */
    @Override
    public int getMaxLevel()
    {
        return 1;
    }

    /**
     * 表示这个附魔是否与其他附魔共存
     * @param ench
     * @return
     */
    @Override
    public boolean canApplyTogether(Enchantment ench)
    {
        return super.canApplyTogether(ench) && ench.effectId != silkTouch.effectId && ench.effectId != fortune.effectId;
    }

    /**
     * 这个附魔可以作用的物品
     * @param stack
     * @return
     */
    @Override
    public boolean canApply(ItemStack stack)
    {
        return stack.getItem() == Items.shears ? true : super.canApply(stack);
    }
}
