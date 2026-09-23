package me.pajic.coalnuggets;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

//? >=26.3
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;

public class CoalNuggets {

    public static final String MOD_ID = /*$ mod_id*/ "coalnuggets";

    public static final ResourceKey<Item> COAL_NUGGET_KEY = ResourceKey.create(Registries.ITEM, id("coal_nugget"));
    public static final ResourceKey<Item> CHARCOAL_NUGGET_KEY = ResourceKey.create(Registries.ITEM, id("charcoal_nugget"));
    public static final TagKey<Item> COAL_NUGGETS = TagKey.create(Registries.ITEM, id("coal_nuggets"));
    //? >=26.3
    public static final ResourceKey<ContextIntProvider> COOKING_TIME_COAL_NUGGETS = ResourceKey.create(Registries.CONTEXT_INT_PROVIDER, id("cooking/time_coal_nuggets"));

    public static final Item COAL_NUGGET = new Item(buildProperties(COAL_NUGGET_KEY));
    public static final Item CHARCOAL_NUGGET = new Item(buildProperties(CHARCOAL_NUGGET_KEY));

    private static Item.Properties buildProperties(ResourceKey<Item> key) {
        return new Item.Properties()/*? >=26.3 {*/.cookingFuel(COOKING_TIME_COAL_NUGGETS)/*?}*//*? >=26.1 {*/.setId(key)/*?}*/;
    }

    public static void onInitialize() {
        ModDatapacks.init();
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
