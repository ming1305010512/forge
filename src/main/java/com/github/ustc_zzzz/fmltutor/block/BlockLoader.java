package com.github.ustc_zzzz.fmltutor.block;

import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:17:16
 * @Description：块加载类
 */
public class BlockLoader {

    public static Block grassBlock = new BlockGrassBlock();

    public BlockLoader(FMLPreInitializationEvent event) {
        register(grassBlock, "grass_block");
    }

    private static void register(Block block,String name){
        GameRegistry.registerBlock(block.setRegistryName(name));
    }

    /**
     * 为这个方块对应的物品添加模型和材质
     */
    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        registerRender(grassBlock);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block){
        ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(),"inventor");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0,model);
    }
}
