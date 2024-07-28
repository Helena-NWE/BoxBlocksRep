package io.github.Helena_NWE.box_blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;



public class BoxItems extends Blocks{


	public static final Block BLUE_SKYBLOCK = new BlueBlock(QuiltBlockSettings.of(Material.GLASS, MapColor.BLUE).luminance(15));


	public static void register(ModContainer box_blocks) {

		Registry.register(Registry.BLOCK, new Identifier(box_blocks.metadata().id(), "blue_skyblock"), BLUE_SKYBLOCK);
		Registry.register(Registry.ITEM, new Identifier(box_blocks.metadata().id(), "blue_skyblock"), new BlockItem(BLUE_SKYBLOCK, new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		}



	public static final BlockEntityType<SkyBlock> SKY_BLOCK_BLOCK_ENTITY_TYPE =
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("box_blocks","skyblock"), QuiltBlockEntityTypeBuilder.create(SkyBlock::new,BLUE_SKYBLOCK).build());


}



