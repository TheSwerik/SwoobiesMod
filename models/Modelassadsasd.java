// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelassadsasd extends ModelBase {
	private final ModelRenderer bb_main;

	public Modelassadsasd() {
		textureWidth = 16;
		textureHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 3, -5.0F, -22.0F, -4.0F, 10, 5, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 3, -4.0F, -21.0F, -6.0F, 8, 3, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}