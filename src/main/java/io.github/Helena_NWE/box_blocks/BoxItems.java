package io.github.Helena_NWE.box_blocks;

import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class BoxItems {
	public static final Block BLUE_SKYBLOCK = new Block(QuiltBlockSettings.of(Material.GLASS, MapColor.BLUE).luminance(15));

	public static void register(ModContainer box_blocks) {

		Registry.register(Registry.BLOCK, new Identifier(box_blocks.metadata().id(), "blue_skyblock"), BLUE_SKYBLOCK);
		Registry.register(Registry.ITEM, new Identifier(box_blocks.metadata().id(), "blue_skyblock"), new BlockItem(BLUE_SKYBLOCK, new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
		}
}
