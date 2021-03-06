package com.github.ustc_zzzz.fmltutor.common;

import com.github.ustc_zzzz.fmltutor.enchantment.EnchantmentLoader;
import com.github.ustc_zzzz.fmltutor.potion.PotionLoader;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/3
 * @Time:9:59
 * @Description:事件加载类(注册已有的事件和注册新的事件)
 */
public class EventLoader {

    /**
     * 创建event_bus，将所有自定义事件在这里被注册
     */
    public static final EventBus EVENT_BUS = new EventBus();

    public EventLoader() {
        MinecraftForge.EVENT_BUS.register(this);
        EventLoader.EVENT_BUS.register(this);
    }

    /**
     * @SubscribeEvent注解的作用是Forge在你注册这个类的时候，会扫描具有该注解的方法，然后挂钩
     * 此方法挂钩的是物品即将被捡起的时候触发的事件PlayerEvent.ItemPickupEvent
     * @param event
     */
    @SubscribeEvent
    public void onPlayerItemPickup(PlayerEvent.ItemPickupEvent event){
        if (event.player.isServerWorld()){
            String info = String.format("%s picks up: %s",event.player.getName(),event.pickedUp.getEntityItem());
            ConfigLoader.logger().info(info);
        }
    }

    /**
     * 挂钩玩家在和物品和方块互动时触发的事件PlayerInteractEvent
     * @param event
     */
    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event){
        if (!event.world.isRemote){
            String info = String.format("%s interacts with: %s", event.entityPlayer.getName(), event.pos);
            ConfigLoader.logger().info(info);
        }
    }


    /**
     * 监听玩家右键点击草块的事件
     * @param event
     */
    @SubscribeEvent
    public void onPlayerClickGrassBlock(PlayerRightClickGrassBlockEvent event){
        // TODO：需要进行测试看下，可以将下面换成日志形式测试
        if (!event.world.isRemote)
        {
            BlockPos pos = event.pos;
            Entity tnt = new EntityTNTPrimed(event.world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, null);
            event.world.spawnEntityInWorld(tnt);
        }
    }

    /**
     * 监听玩家交互事件
     * @param event
     */
    @SubscribeEvent
    public void onEntityInteract(EntityInteractEvent event)
    {
        EntityPlayer player = event.entityPlayer;
        if (player.isServerWorld() && event.target instanceof EntityPig)
        {
            EntityPig pig = (EntityPig) event.target;
            ItemStack stack = player.getCurrentEquippedItem();
            if (stack != null && (stack.getItem() == Items.wheat || stack.getItem() == Items.wheat_seeds))
            {
                /**
                 * setDefficultyScaled方法设置的属性表示受到的伤害随着难度的变化而变化。
                 *  setExplosion方法设置的属性表示该伤害由爆炸造成，爆炸保护附魔会起到作用。
                 */
                player.attackEntityFrom((new DamageSource("byPig")).setDifficultyScaled().setExplosion(), 8.0F);
                player.worldObj.createExplosion(pig, pig.posX, pig.posY, pig.posZ, 2.0F, false);
                pig.setDead();
            }
        }
    }

    /**
     * 监听物品掉落事件(当一个方块掉落收获物品时触发)
     * @param event
     */
    @SubscribeEvent
    public void onBlockHarvestDrops(BlockEvent.HarvestDropsEvent event){
        if (!event.world.isRemote && event.harvester!=null){
            ItemStack itemStack = event.harvester.getHeldItem();
            if (EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.fireBurn.effectId, itemStack) > 0
                    && itemStack.getItem() != Items.shears)
            {
                for (int i = 0; i < event.drops.size(); ++i)
                {
                    ItemStack stack = event.drops.get(i);
                    ItemStack newStack = FurnaceRecipes.instance().getSmeltingResult(stack);
                    if (newStack != null)
                    {
                        newStack = newStack.copy();
                        newStack.stackSize = stack.stackSize;
                        event.drops.set(i, newStack);
                    }
                    else if (stack != null)
                    {
                        Block block = Block.getBlockFromItem(stack.getItem());
                        boolean b = (block == null);
                        if (!b && (block.isFlammable(event.world, event.pos, EnumFacing.DOWN)
                                || block.isFlammable(event.world, event.pos, EnumFacing.EAST)
                                || block.isFlammable(event.world, event.pos, EnumFacing.NORTH)
                                || block.isFlammable(event.world, event.pos, EnumFacing.SOUTH)
                                || block.isFlammable(event.world, event.pos, EnumFacing.UP)
                                || block.isFlammable(event.world, event.pos, EnumFacing.WEST)))
                        {
                            event.drops.remove(i);
                        }
                    }
                }
            }
        }
    }

    /**
     * 当一个实体被设置为受到伤害时，LivingHurtEvent将被触发。
     * @param event
     */
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event)
    {
        if (event.source.getDamageType().equals("fall"))
        {
            PotionEffect effect = event.entityLiving.getActivePotionEffect(PotionLoader.potionFallProtection);
            if (effect != null)
            {
                if (effect.getAmplifier() == 0)
                {
                    event.ammount /= 2;
                }
                else
                {
                    event.ammount = 0;
                }
            }
        }
    }



    //新建一个我们想要的事件类
    @Cancelable
    public static class PlayerRightClickGrassBlockEvent extends net.minecraftforge.event.entity.player.PlayerEvent
    {
        public final BlockPos pos;
        public final World world;

        public PlayerRightClickGrassBlockEvent(EntityPlayer player, BlockPos pos, World world)
        {
            super(player);
            this.pos = pos;
            this.world = world;
        }
    }
}
