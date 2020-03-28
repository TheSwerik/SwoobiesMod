
package de.swerik.swoobies.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.Block;

import de.swerik.swoobies.SwoobiesElements;

@SwoobiesElements.ModElement.Tag
public class WomanJuiceBlock extends SwoobiesElements.ModElement {
	@ObjectHolder("swoobies:womanjuice")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("swoobies:womanjuice_bucket")
	public static final Item bucket = null;
	private FlowingFluid flowing = null;
	private FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;
	public WomanJuiceBlock(SwoobiesElements instance) {
		super(instance, 10);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerFluids(RegistryEvent.Register<Fluid> event) {
		event.getRegistry().register(still);
		event.getRegistry().register(flowing);
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes.builder(new ResourceLocation("swoobies:blocks/omanuice"), new ResourceLocation("swoobies:blocks/omanuice"))
						.luminosity(90).density(1000).viscosity(1000)).block(() -> block);
		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("womanjuice");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("womanjuice_flowing");
		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER)) {
		}.setRegistryName("womanjuice"));
	}
}
