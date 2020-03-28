package de.swerik.swoobies.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import de.swerik.swoobies.block.WomanJuiceBlock;
import de.swerik.swoobies.SwoobiesElements;

@SwoobiesElements.ModElement.Tag
public class WomanJuiceItemRightClickedOnBlockProcedure extends SwoobiesElements.ModElement {
	public WomanJuiceItemRightClickedOnBlockProcedure(SwoobiesElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WomanJuiceItemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WomanJuiceItemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WomanJuiceItemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WomanJuiceItemRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), WomanJuiceBlock.block.getDefaultState(), 3);
	}
}
