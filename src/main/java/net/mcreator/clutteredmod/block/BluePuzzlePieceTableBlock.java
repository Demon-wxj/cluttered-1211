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
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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

public class BluePuzzlePieceTableBlock
extends Block {
    public static BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1.0f, 10.0f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public BluePuzzlePieceTableBlock() {
        super(PROPERTIES);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, Direction.NORTH));
    }

    public void appendHoverText(ItemStack itemstack, net.minecraft.world.item.Item.TooltipContext world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add((Component)Component.literal((String)"Stardew Valley"));
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
            default -> Shapes.or((VoxelShape)BluePuzzlePieceTableBlock.box((double)0.0, (double)12.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0), (VoxelShape)BluePuzzlePieceTableBlock.box((double)6.0, (double)0.0, (double)6.5, (double)9.0, (double)12.0, (double)9.5));
            case NORTH -> Shapes.or((VoxelShape)BluePuzzlePieceTableBlock.box((double)0.0, (double)12.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0), (VoxelShape)BluePuzzlePieceTableBlock.box((double)7.0, (double)0.0, (double)6.5, (double)10.0, (double)12.0, (double)9.5));
            case EAST -> Shapes.or((VoxelShape)BluePuzzlePieceTableBlock.box((double)0.0, (double)12.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0), (VoxelShape)BluePuzzlePieceTableBlock.box((double)6.5, (double)0.0, (double)7.0, (double)9.5, (double)12.0, (double)10.0));
            case WEST -> Shapes.or((VoxelShape)BluePuzzlePieceTableBlock.box((double)0.0, (double)12.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0), (VoxelShape)BluePuzzlePieceTableBlock.box((double)6.5, (double)0.0, (double)6.0, (double)9.5, (double)12.0, (double)9.0));
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
        BlockRenderLayerMap.INSTANCE.putBlock(LuphieclutteredmodModBlocks.BLUE_PUZZLE_PIECE_TABLE, RenderType.solid());
    }
}

