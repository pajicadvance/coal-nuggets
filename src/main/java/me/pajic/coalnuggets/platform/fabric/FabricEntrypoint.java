package me.pajic.coalnuggets.platform.fabric;

//? fabric {

import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import me.pajic.coalnuggets.CoalNuggets;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		initItemRegistry();
		initFuelRegistry();
		initCreativeTabs();
	}

	private static void initItemRegistry() {
		Registry.register(
				BuiltInRegistries.ITEM,
				CoalNuggets.COAL_NUGGET_KEY,
				CoalNuggets.COAL_NUGGET
		);
		Registry.register(
				BuiltInRegistries.ITEM,
				CoalNuggets.CHARCOAL_NUGGET_KEY,
				CoalNuggets.CHARCOAL_NUGGET
		);
	}

	private static void initFuelRegistry() {
		FuelValueEvents.BUILD.register((builder, context) -> {
			builder.add(CoalNuggets.COAL_NUGGET, 200);
			builder.add(CoalNuggets.CHARCOAL_NUGGET, 200);
		});
	}

	private static void initCreativeTabs() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
			entries.insertAfter(Items.COAL, CoalNuggets.COAL_NUGGET);
			entries.insertAfter(Items.CHARCOAL, CoalNuggets.CHARCOAL_NUGGET);
		});
	}
}
//?}
