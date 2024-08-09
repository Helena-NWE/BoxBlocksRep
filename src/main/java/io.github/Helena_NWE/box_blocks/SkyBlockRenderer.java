package io.github.Helena_NWE.box_blocks;


import com.mojang.blaze3d.vertex.Tessellator;
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
		Quaternion rot = new Quaternion(0,(float)cos(angle/360),0, (float)sin(angle/360));
		return rot;
	}

	private static ItemStack stack = new ItemStack(Items.CYAN_CONCRETE, 1);

	public SkyBlockRenderer(BlockEntityRendererFactory.Context ctx) {}

	@Override
	public void render(SkyBlock blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

		matrices.push();
		// Calculate the current offset in the y value
		double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
		// Move the item
		matrices.translate(0.5, -0.25, 0.5);


		// Rotate the item
		//matrices.multiply(RotationY(blockEntity.getWorld().getTime() + tickDelta));
		matrices.scale((float)4,(float)4,(float)4);

		int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());
		//MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);

		// Mandatory call after GL calls
		matrices.pop();


	}
}
