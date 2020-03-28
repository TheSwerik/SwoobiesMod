
package de.swerik.swoobies.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import de.swerik.swoobies.procedures.WomanizerPotionStartedappliedProcedure;
import de.swerik.swoobies.SwoobiesElements;

@SwoobiesElements.ModElement.Tag
public class WomanizerPotionItem extends SwoobiesElements.ModElement {
	@ObjectHolder("swoobies:womanizerpotion")
	public static final Item block = null;
	public WomanizerPotionItem(SwoobiesElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)
					.food((new Food.Builder()).hunger(10).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("womanizerpotion");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				WomanizerPotionStartedappliedProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
