package io.github.Helena_NWE.box_blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class SkyBlock extends BlockEntity {
	public SkyBlock(BlockPos pos, BlockState state) {
		super(BoxItems.SKY_BLOCK_BLOCK_ENTITY_TYPE, pos, state);
	}
}
