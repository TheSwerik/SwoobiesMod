package de.swerik.swoobies.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import de.swerik.swoobies.potion.WomanizerPotion;
import de.swerik.swoobies.item.AsdArmorItem;
import de.swerik.swoobies.SwoobiesElements;

@SwoobiesElements.ModElement.Tag
public class WomanizerPotionStartedappliedProcedure extends SwoobiesElements.ModElement {
	public WomanizerPotionStartedappliedProcedure(SwoobiesElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WomanizerPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(WomanizerPotion.potion, (int) 1e+26, (int) 1));
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(2, new ItemStack(AsdArmorItem.body, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */
	}
}
