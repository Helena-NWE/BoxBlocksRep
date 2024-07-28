package io.github.Helena_NWE.box_blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class SkyBlock extends BlockEntity {
	private int number = 7;

	public SkyBlock(BlockPos pos, BlockState state) {
		super(BoxItems.SKY_BLOCK_BLOCK_ENTITY_TYPE, pos, state);
	}


	@Override
	public void writeNbt(NbtCompound nbt) {
		// Save the current value of the number to the nbt
		nbt.putInt("number", number);

		super.writeNbt(nbt);
	}
}
