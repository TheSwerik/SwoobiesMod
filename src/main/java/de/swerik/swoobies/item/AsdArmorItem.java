
package de.swerik.swoobies.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import de.swerik.swoobies.SwoobiesElements;

@SwoobiesElements.ModElement.Tag
public class AsdArmorItem extends SwoobiesElements.ModElement {
	@ObjectHolder("swoobies:swoobieshelmet")
	public static final Item helmet = null;
	@ObjectHolder("swoobies:swoobiesbody")
	public static final Item body = null;
	@ObjectHolder("swoobies:swoobieslegs")
	public static final Item legs = null;
	@ObjectHolder("swoobies:swoobiesboots")
	public static final Item boots = null;
	public AsdArmorItem(SwoobiesElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 1;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{0, 0, 0, 0}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 0;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return null;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "swoobies";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedBody = new Modelswoobies().bb_main;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "swoobies:textures/swoobies_texture.png";
			}
		}.setRegistryName("swoobiesbody"));
	}
	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modelswoobies extends EntityModel<Entity> {
		private final RendererModel bb_main;
		public Modelswoobies() {
			textureWidth = 16;
			textureHeight = 16;
			bb_main = new RendererModel(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -7.0F, -25.0F, -8.0F, 14, 5, 6, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -26.0F, -8.0F, 5, 7, 6, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 1.0F, -26.0F, -8.0F, 5, 7, 6, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -25.0F, -10.0F, 5, 5, 6, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 1.0F, -25.0F, -10.0F, 5, 5, 6, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -23.0F, -11.0F, 1, 1, 5, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 3.0F, -23.0F, -11.0F, 1, 1, 5, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bb_main.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
		}
	}
}
