package me.pajic.coalnuggets;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ModDatapacks {

    private static final Set<String> PACKS = new HashSet<>();

    public static void init() {
        //~ if <26.1 'recipes' -> 'recipes_old'
        PACKS.add("recipes");
    }

    public static Stream<String> getPacks() {
        return PACKS.stream();
    }
}
