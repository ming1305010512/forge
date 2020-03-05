package com.github.ustc_zzzz.fmltutor.crafting;

import com.github.ustc_zzzz.fmltutor.block.BlockLoader;
import com.github.ustc_zzzz.fmltutor.common.ConfigLoader;
import com.github.ustc_zzzz.fmltutor.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:19:37
 * @Description:合成表加载类
 */
public class CraftingLoader {

    public CraftingLoader() {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    /**
     * 注册食物
     */
    private static void registerRecipe(){

        //合成金蛋
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.goldenEgg),new Object[]{
                "###", "#*#", "###", '#', Items.gold_ingot, '*', Items.egg
        });
        //合成草块
        GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.grassBlock),new Object[]{
                "##", "##", '#', Blocks.vine
        });
        //一个草块得到四个葡萄
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.vine,4),BlockLoader.grassBlock);

        //合成一个红石稿
        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.redstonePickaxe),new Object[]{
                "###", " * ", " * ", '#', Items.redstone, '*', Items.stick
        });
        //合成一个红石苹果
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneApple), new Object[]{
                "###", "#*#", "###", '#', Items.redstone, '*', Items.apple
        });

        /**
         * 盔甲合成
         */
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneHelmet), new Object[]
                {
                        "###", "# #", '#', Items.redstone
                });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneChestplate), new Object[]
                {
                        "# #", "###", "###", '#', Items.redstone
                });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneLeggings), new Object[]
                {
                        "###", "# #", "# #", '#', Items.redstone
                });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneBoots), new Object[]
                {
                        "# #", "# #", '#', Items.redstone
                });
    }

    /**
     * 注册熔炼
     */
    private static void registerSmelting(){

        //第一个参数是待燃烧的物品，第二个参数是燃烧后的物品，第三个参数是燃烧后玩家可以得到的经验
        GameRegistry.addSmelting(BlockLoader.grassBlock,new ItemStack(Items.coal),0.5F);
    }

    /**
     * 注册燃料
     */
    private static void registerFuel(){
        GameRegistry.registerFuelHandler(new IFuelHandler() {
            /**
             * 判断物品的烧炼时间，如果返回0，则为不能判断物品的烧炼时间
             * 烧炼时间的单位为gametick,一秒为20个gametick
             * @param fuel
             * @return
             */
            @Override
            public int getBurnTime(ItemStack fuel) {
                return Items.diamond != fuel.getItem() ? 0 : Math.max(0, ConfigLoader.diamondBurnTime)*20;
            }
        });
    }

}
