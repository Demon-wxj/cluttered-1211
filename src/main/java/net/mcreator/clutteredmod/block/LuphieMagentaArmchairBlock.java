// Derived from Cluttered 2.1.0 (blake/unilock); local Minecraft 1.21.1 API adaptation.
package net.mcreator.clutteredmod.block;

import java.util.Collections;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LuphieMagentaArmchairBlock
extends Block {
    public static BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(1.0f, 10.0f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public LuphieMagentaArmchairBlock() {
        super(PROPERTIES);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, Direction.NORTH));
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return (switch ((Direction)state.getValue((Property)FACING)) {
            default -> Shapes.or((VoxelShape)LuphieMagentaArmchairBlock.box((double)-14.0, (double)10.0, (double)0.0, (double)14.0, (double)23.0, (double)4.0), (VoxelShape[])new VoxelShape[]{LuphieMagentaArmchairBlock.box((double)8.0, (double)10.0, (double)0.0, (double)12.0, (double)17.0, (double)16.0), LuphieMagentaArmchairBlock.box((double)-12.0, (double)10.0, (double)0.0, (double)-8.0, (double)17.0, (double)16.0), LuphieMagentaArmchairBlock.box((double)-14.0, (double)12.0, (double)0.0, (double)-12.0, (double)17.0, (double)16.0), LuphieMagentaArmchairBlock.box((double)-12.0, (double)0.0, (double)0.0, (double)12.0, (double)10.0, (double)16.0), LuphieMagentaArmchairBlock.box((double)12.0, (double)12.0, (double)0.0, (double)14.0, (double)17.0, (double)16.0)});
            case NORTH -> Shapes.or((VoxelShape)LuphieMagentaArmchairBlock.box((double)2.0, (double)10.0, (double)12.0, (double)30.0, (double)23.0, (double)16.0), (VoxelShape[])new VoxelShape[]{LuphieMagentaArmchairBlock.box((double)4.0, (double)10.0, (double)0.0, (double)8.0, (double)17.0, (double)16.0), LuphieMagentaArmchairBlock.box((double)24.0, (double)10.0, (double)0.0, (double)28.0, (double)17.0, (double)16.0), LuphieMagentaArmchairBlock.box((double)28.0, (double)12.0, (double)0.0, (double)30.0, (double)17.0, (double)16.0), LuphieMagentaArmchairBlock.box((double)4.0, (double)0.0, (double)0.0, (double)28.0, (double)10.0, (double)16.0), LuphieMagentaArmchairBlock.box((double)2.0, (double)12.0, (double)0.0, (double)4.0, (double)17.0, (double)16.0)});
            case EAST -> Shapes.or((VoxelShape)LuphieMagentaArmchairBlock.box((double)0.0, (double)10.0, (double)2.0, (double)4.0, (double)23.0, (double)30.0), (VoxelShape[])new VoxelShape[]{LuphieMagentaArmchairBlock.box((double)0.0, (double)10.0, (double)4.0, (double)16.0, (double)17.0, (double)8.0), LuphieMagentaArmchairBlock.box((double)0.0, (double)10.0, (double)24.0, (double)16.0, (double)17.0, (double)28.0), LuphieMagentaArmchairBlock.box((double)0.0, (double)12.0, (double)28.0, (double)16.0, (double)17.0, (double)30.0), LuphieMagentaArmchairBlock.box((double)0.0, (double)0.0, (double)4.0, (double)16.0, (double)10.0, (double)28.0), LuphieMagentaArmchairBlock.box((double)0.0, (double)12.0, (double)2.0, (double)16.0, (double)17.0, (double)4.0)});
            case WEST -> Shapes.or((VoxelShape)LuphieMagentaArmchairBlock.box((double)12.0, (double)10.0, (double)-14.0, (double)16.0, (double)23.0, (double)14.0), (VoxelShape[])new VoxelShape[]{LuphieMagentaArmchairBlock.box((double)0.0, (double)10.0, (double)8.0, (double)16.0, (double)17.0, (double)12.0), LuphieMagentaArmchairBlock.box((double)0.0, (double)10.0, (double)-12.0, (double)16.0, (double)17.0, (double)-8.0), LuphieMagentaArmchairBlock.box((double)0.0, (double)12.0, (double)-14.0, (double)16.0, (double)17.0, (double)-12.0), LuphieMagentaArmchairBlock.box((double)0.0, (double)0.0, (double)-12.0, (double)16.0, (double)10.0, (double)12.0), LuphieMagentaArmchairBlock.box((double)0.0, (double)12.0, (double)12.0, (double)16.0, (double)17.0, (double)14.0)});
        }).move(offset.x, offset.y, offset.z);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)this.defaultBlockState().setValue((Property)FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue((Property)FACING, rot.rotate((Direction)state.getValue((Property)FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation((Direction)state.getValue((Property)FACING)));
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
        BlockRenderLayerMap.INSTANCE.putBlock(LuphieclutteredmodModBlocks.LUPHIE_MAGENTA_ARMCHAIR, RenderType.solid());
    }
}

