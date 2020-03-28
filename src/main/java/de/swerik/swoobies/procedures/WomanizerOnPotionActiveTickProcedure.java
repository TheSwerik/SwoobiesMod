package de.swerik.swoobies.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import de.swerik.swoobies.item.AsdArmorItem;
import de.swerik.swoobies.SwoobiesElements;

@SwoobiesElements.ModElement.Tag
public class WomanizerOnPotionActiveTickProcedure extends SwoobiesElements.ModElement {
	public WomanizerOnPotionActiveTickProcedure(SwoobiesElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WomanizerOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(AsdArmorItem.body, (int) (1)).getItem() == p.getItem(), (int) 99);
		if ((!(((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
				.getItem() == new ItemStack(AsdArmorItem.body, (int) (1)).getItem()))) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).inventory.armorInventory.set(2, new ItemStack(AsdArmorItem.body, (int) (1)));
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			/* @ItemStack */}
	}
}
