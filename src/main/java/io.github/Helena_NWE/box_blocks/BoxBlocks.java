package io.github.Helena_NWE.box_blocks;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.Helena_NWE.box_blocks.BoxItems.SKY_BLOCK_BLOCK_ENTITY_TYPE;

public class BoxBlocks implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Box Blocks");

	@Override
	public void onInitialize(ModContainer box_blocks) {
		LOGGER.info("Hello Quilt world from {}!", box_blocks.metadata().name());
		BoxItems.register(box_blocks);
		buffers.register(box_blocks);
		BlockEntityRendererFactories.register(SKY_BLOCK_BLOCK_ENTITY_TYPE, SkyBlockRenderer::new);
	}
}
