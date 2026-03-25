package me.pajic.coalnuggets.platform.neoforge;

//? neoforge {

/*import me.pajic.coalnuggets.CoalNuggets;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(CoalNuggets.MOD_ID)
@EventBusSubscriber(modid = CoalNuggets.MOD_ID)
public class NeoforgeEntrypoint {

	@SubscribeEvent
	private static void initItemRegistry(RegisterEvent event) {
		event.register(
				Registries.ITEM,
				registry -> {
					registry.register(CoalNuggets.COAL_NUGGET_KEY, CoalNuggets.COAL_NUGGET);
					registry.register(CoalNuggets.CHARCOAL_NUGGET_KEY, CoalNuggets.CHARCOAL_NUGGET);
				}
		);
	}

	@SubscribeEvent
	private static void initCreativeTabs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.insertAfter(Items.COAL.getDefaultInstance(), CoalNuggets.COAL_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(Items.CHARCOAL.getDefaultInstance(), CoalNuggets.CHARCOAL_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}
}
*///?}
