package me.pajic.coalnuggets.platform.fabric;

//? fabric {

import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import me.pajic.coalnuggets.CoalNuggets;
import me.pajic.coalnuggets.ModDatapacks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

//? <26.1 {
/*import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
*///?} else {
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
//?}

//? <26.3 && >=26.1 {
/*import net.fabricmc.fabric.api.registry.FuelValueEvents;
*///?} else <26.1 {
/*import net.fabricmc.fabric.api.registry.FuelRegistry;
*///?}

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
        CoalNuggets.onInitialize();
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
        //? <26.1 {
        /*ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.COAL, CoalNuggets.COAL_NUGGET);
            entries.addAfter(Items.CHARCOAL, CoalNuggets.CHARCOAL_NUGGET);
        });
        *///?} else {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.insertAfter(Items.COAL, CoalNuggets.COAL_NUGGET);
            entries.insertAfter(Items.CHARCOAL, CoalNuggets.CHARCOAL_NUGGET);
        });
        //?}
        //? <26.1 {
        /*FuelRegistry.INSTANCE.add(CoalNuggets.COAL_NUGGET, 200);
        FuelRegistry.INSTANCE.add(CoalNuggets.CHARCOAL_NUGGET, 200);
        *///?} else <26.3 && >=26.1 {
        /*FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(CoalNuggets.COAL_NUGGET, 200);
            builder.add(CoalNuggets.CHARCOAL_NUGGET, 200);
        });
        *///?}
        FabricLoader.getInstance().getModContainer(CoalNuggets.MOD_ID).ifPresent(container ->
                //~ if <26.1 'ResourceLoader.registerBuiltinPack' -> 'ResourceManagerHelper.registerBuiltinResourcePack'
                ModDatapacks.getPacks().forEach(s -> ResourceLoader.registerBuiltinPack(
                        CoalNuggets.id(s),
                        container,
                        Component.translatable("coalnuggets.pack." + s),
                        //~ if <26.1 'PackActivationType' -> 'ResourcePackActivationType'
                        PackActivationType.ALWAYS_ENABLED
                ))
        );
	}
}
//?}
