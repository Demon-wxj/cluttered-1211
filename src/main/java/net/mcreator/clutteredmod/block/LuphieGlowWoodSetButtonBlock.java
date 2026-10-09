// Derived from Cluttered 2.1.0 (blake/unilock); local Minecraft 1.21.1 API adaptation.
package net.mcreator.clutteredmod.block;

import java.util.Collections;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.storage.loot.LootParams;

public class LuphieGlowWoodSetButtonBlock
extends ButtonBlock {
    public static BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f, 3.0f).lightLevel(s -> 1).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true);

    public LuphieGlowWoodSetButtonBlock() {
        super(BlockSetType.OAK, 30, PROPERTIES);
        FlammableBlockRegistry.getDefaultInstance().add((Block)this, 5, 0);
    }

    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty()) {
            return dropsOriginal;
        }
        return Collections.singletonList(new ItemStack((ItemLike)this, 1));
    }

    @Environment(value=EnvType.CLIENT)
    public static void clientInit() {
        BlockRenderLayerMap.INSTANCE.putBlock(LuphieclutteredmodModBlocks.LUPHIE_GLOW_WOOD_SET_BUTTON, RenderType.solid());
    }
}

