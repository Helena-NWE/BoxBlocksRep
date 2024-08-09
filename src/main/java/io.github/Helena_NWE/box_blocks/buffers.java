package io.github.Helena_NWE.box_blocks;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.blaze3d.Blaze3D;
import com.mojang.blaze3d.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.registry.api.event.RegistryEvents;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.registry.Registry;


public class buffers{

	public static void register(ModContainer boxBlocks) {
		HudRenderCallback.EVENT.register((drawContext, tickDeltaManager) ->{
// Get the transformation matrix from the matrix stack, alongside the tessellator instance and a new buffer builder.
			Matrix4f transformationMatrix = drawContext.peek().getModel();
			//Matrix4f transformationMatrix = drawContext.getMatrices().peek().getPositionMatrix();
			Tessellator tessellator = Tessellator.getInstance();

// Begin a triangle strip buffer using the POSITION_COLOR vertex format.

			BufferBuilder buffer = tessellator.getBufferBuilder();
			buffer.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

// Write our vertices, Z doesn't really matter since it's on the HUD.
			buffer.vertex(transformationMatrix, 20,20,5).color(0xFF414141);
			buffer.vertex(transformationMatrix, 5,40,5).color(0xFF000000);
			buffer.vertex(transformationMatrix, 35,40,5).color(0xFF000000);
			buffer.vertex(transformationMatrix, 20,60,5).color(0xFF414141);

// We'll get to this bit in the next section.
			RenderSystem.setShader(GameRenderer::getPositionColorShader);
			//RenderSystem.setShader(GameRenderer::getPositionColorProgram);
			RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);

// Draw the buffer onto the screen.
			//BufferRenderer.drawWithShader(buffer.end());
			BufferRenderer.draw(buffer.end());
			//BufferRenderer.drawWithGlobalProgram(buffer.end());
		}
		);
	};
}
