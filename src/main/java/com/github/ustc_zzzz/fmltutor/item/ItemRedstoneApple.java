package com.github.ustc_zzzz.fmltutor.item;

import com.github.ustc_zzzz.fmltutor.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/3
 * @Time:13:36
 * @Description:红石苹果
 */
public class ItemRedstoneApple extends ItemFood {


    public ItemRedstoneApple() {
        //第一个参数表示食物所能回复的饥饿值，第二个参数表示食物所能添加的相对饱和度，其正比于饱和度和饥饿值的比值
        //第三个参数表示该食物能否被狼食用
        //饱和度计算：2*amount*saturation
        super(4, 0.6F, false);
        //表示该食物何时何地都能被食用
        this.setAlwaysEdible();
        this.setUnlocalizedName("redstoneApple");
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
        /**
         * 添加食用后的一种效果
         * 参数一：对应药水效果的potionId
         * 参数二：表示对应药水效果的持续时间，已秒计数
         * 参数三：对应药水效果的等级
         * 参数四：产生该药水效果的概率
         */
        this.setPotionEffect(Potion.absorption.id,10,1,1.0F);
    }

    /**
     * 食物食用后添加更多效果（这里给玩家带来十秒的饱和效果和十点经验）
     * @param stack
     * @param worldIn
     * @param player
     */
    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
            player.addPotionEffect(new PotionEffect(Potion.saturation.id, 200, 1));
            player.addExperience(10);
        }
        super.onFoodEaten(stack, worldIn, player);
    }
}
