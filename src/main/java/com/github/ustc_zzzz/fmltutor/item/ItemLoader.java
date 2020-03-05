package com.github.ustc_zzzz.fmltutor.item;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:16:22
 * @Description:物品加载类
 */
public class ItemLoader {

    /**
     * 金蛋
     */
    public static Item goldenEgg = new ItemGoldenEgg();
    /**
     * 红石稿
     */
    public static ItemPickaxe redstonePickaxe = new ItemRedstonePickaxe();
    /**
     * 红石苹果
     */
    public static ItemFood redstoneApple = new ItemRedstoneApple();

    /**
     * 盔甲
     */
    public static ItemArmor redstoneHelmet = new ItemRedstoneArmor.Helmet();
    public static ItemArmor redstoneChestplate = new ItemRedstoneArmor.Chestplate();
    public static ItemArmor redstoneLeggings = new ItemRedstoneArmor.Leggings();
    public static ItemArmor redstoneBoots = new ItemRedstoneArmor.Boots();

    public ItemLoader(FMLPreInitializationEvent event) {
        register(goldenEgg,"golden_egg");
        register(redstonePickaxe,"redstone_pickaxe");
        register(redstoneApple,"redstone_apple");

        //注册盔甲
        register(redstoneHelmet, "redstone_helmet");
        register(redstoneChestplate, "redstone_chestplate");
        register(redstoneLeggings, "redstone_leggings");
        register(redstoneBoots, "redstone_boots");
    }
    private static void register(Item item,String name){
        GameRegistry.registerItem(item.setRegistryName(name));
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        registerRender(goldenEgg);
        registerRender(redstonePickaxe);
        registerRender(redstoneApple);

        //为盔甲添加模型材质
        registerRender(redstoneHelmet);
        registerRender(redstoneChestplate);
        registerRender(redstoneLeggings);
        registerRender(redstoneBoots);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item){
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(),"inventory");
        ModelLoader.setCustomModelResourceLocation(item,0,model);
    }

}
