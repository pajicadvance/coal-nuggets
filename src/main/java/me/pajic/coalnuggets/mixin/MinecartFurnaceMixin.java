package me.pajic.coalnuggets.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import me.pajic.coalnuggets.CoalNuggets;
import net.minecraft.world.entity.vehicle./*? >=26.1 {*/minecart./*?}*/MinecartFurnace;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecartFurnace.class)
public class MinecartFurnaceMixin {

    @ModifyExpressionValue(
            //~ if <26.1 'addFuel' -> 'interact'
            method = "addFuel",
            at = @At(
                    value = "INVOKE",
                    //? <26.1 {
                    /*target = "Lnet/minecraft/world/item/crafting/Ingredient;test(Lnet/minecraft/world/item/ItemStack;)Z"
                    *///?} else {
                    target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/tags/TagKey;)Z"
                    //?}
            )
    )
    private boolean acceptNuggetsAsFuel(boolean original, @Local ItemStack itemStack) {
        return itemStack.is(CoalNuggets.COAL_NUGGETS) || original;
    }

    @ModifyExpressionValue(
            //~ if <26.1 'addFuel' -> 'interact'
            method = "addFuel",
            at = @At(
                    value = "CONSTANT",
                    args = "intValue=3600"
            )
    )
    private int handleNuggetFuelDuration(int original, @Local ItemStack itemStack) {
        return itemStack.is(CoalNuggets.COAL_NUGGETS) ? 450 : original;
    }
}
