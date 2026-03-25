package me.pajic.coalnuggets;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@SuppressWarnings("LoggingSimilarMessage")
public class CoalNuggets {

	public static final String MOD_ID = /*$ mod_id*/ "coalnuggets";

	public static final ResourceKey<Item> COAL_NUGGET_KEY = ResourceKey.create(Registries.ITEM, id("coal_nugget"));
	public static final ResourceKey<Item> CHARCOAL_NUGGET_KEY = ResourceKey.create(Registries.ITEM, id("charcoal_nugget"));
	public static final TagKey<Item> COAL_NUGGETS = TagKey.create(Registries.ITEM, id("coal_nuggets"));

	public static final Item COAL_NUGGET = new Item(new Item.Properties().setId(COAL_NUGGET_KEY));
	public static final Item CHARCOAL_NUGGET = new Item(new Item.Properties().setId(CHARCOAL_NUGGET_KEY));

	private static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
