package me.pajic.coalnuggets;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

//? >=26.3 {
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;
//?}

public class CoalNuggets {

    public static final String MOD_ID = /*$ mod_id*/ "coalnuggets";

    public static final ResourceKey<Item> COAL_NUGGET_KEY = ResourceKey.create(Registries.ITEM, id("coal_nugget"));
    public static final ResourceKey<Item> CHARCOAL_NUGGET_KEY = ResourceKey.create(Registries.ITEM, id("charcoal_nugget"));
    public static final TagKey<Item> COAL_NUGGETS = TagKey.create(Registries.ITEM, id("coal_nuggets"));

    public static final Item COAL_NUGGET = new Item(buildProperties(COAL_NUGGET_KEY));
    public static final Item CHARCOAL_NUGGET = new Item(buildProperties(CHARCOAL_NUGGET_KEY));

    private static Item.Properties buildProperties(ResourceKey<Item> key) {
        return new Item.Properties()
                //? >=26.3 {
                .component(DataComponents.COOKING_FUEL, new CookingFuel(
                        new ResolvableInt.Constant(200),
                        ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER)))
                //?}
                /*? >=26.1 {*/.setId(key)/*?}*/;
    }

    public static void onInitialize() {
        ModDatapacks.init();
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
