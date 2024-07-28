package io.github.Helena_NWE.box_blocks;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Quaternion;
import org.quiltmc.loader.api.minecraft.ClientOnly;

import static java.lang.Math.*;

@ClientOnly
public class SkyBlockRenderer implements BlockEntityRenderer<SkyBlock> {

	private Quaternion RotationY(float angle){
		Quaternion rot = new Quaternion(0,1,0,angle);
		return rot;
	}

	private static ItemStack stack = new ItemStack(Items.JUKEBOX, 1);

	public SkyBlockRenderer(BlockEntityRendererFactory.Context ctx) {}

	@Override
	public void render(SkyBlock blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

		matrices.push();
		// Calculate the current offset in the y value
		double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
		// Move the item
		matrices.translate(0.5, 1.25 + offset, 0.5);


		// Rotate the item
		matrices.multiply(RotationY(blockEntity.getWorld().getTime() + tickDelta));

		MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers, 0);

		// Mandatory call after GL calls
		matrices.pop();

		int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());
		MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);

	}
}