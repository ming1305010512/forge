package com.github.ustc_zzzz.fmltutor.client;

import com.github.ustc_zzzz.fmltutor.block.BlockLoader;
import com.github.ustc_zzzz.fmltutor.item.ItemLoader;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2020/3/2
 * @Time:16:54
 * @Description:添加模型和材质的类（组合在一起）
 */
public class ItemRenderLoader {
    public ItemRenderLoader() {
        ItemLoader.registerRenders();
        BlockLoader.registerRenders();
    }
}
