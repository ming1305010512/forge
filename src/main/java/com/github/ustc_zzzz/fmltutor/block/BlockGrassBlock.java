package com.github.ustc_zzzz.fmltutor.block;

import com.github.ustc_zzzz.fmltutor.common.EventLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:17:03
 * @Description: 创建方块
 */
public class BlockGrassBlock extends Block {

    public BlockGrassBlock() {
        super(Material.ground);
        this.setUnlocalizedName("grassBlock");
        //用于设定方块的硬度
        this.setHardness(0.5F);
        //设定走在方块上的响声
        this.setStepSound(soundTypeGrass);
        //把这个方块放到了名为“方块”的创造模式的物品栏里
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumFacing side, float hitX, float hitY, float hitZ)
    {
        EventLoader.PlayerRightClickGrassBlockEvent event;
        event = new EventLoader.PlayerRightClickGrassBlockEvent(playerIn, pos, worldIn);
        //执行事件
        EventLoader.EVENT_BUS.post(event);
        //如果事件被取消了，就阻止草块变成空气，否则草块就会变成空气
        if (!event.isCanceled() && !worldIn.isRemote)
        {
            worldIn.setBlockToAir(pos);
            return true;
        }
        return false;
    }
}
