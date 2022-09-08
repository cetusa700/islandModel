package DrMoroIsland.IslandGuide;

import DrMoroIsland.Animals.Animal.Herbivore.*;
import DrMoroIsland.Animals.Animal.Predator.*;

import java.util.HashMap;

public class IconsGuide {
    private final static HashMap<Class, String> CLASS_ICONS = new HashMap<>() {{
        put(Wolf.class, "\uD83D\uDC3A");
        put(Boa.class, "\uD83D\uDC0D");
        put(Fox.class, "\uD83E\uDD8A");
        put(Bear.class, "\uD83D\uDC3B");
        put(Eagle.class, "\uD83E\uDD85");
        put(Horse.class, "\uD83D\uDC0E");
        put(Deer.class, "\uD83E\uDD8C");
        put(Rabbit.class, "\uD83D\uDC07");
        put(Mouse.class, "\uD83D\uDC01");
        put(Goat.class, "\uD83D\uDC10");
        put(Sheep.class, "\uD83D\uDC11");
        put(Boar.class, "\uD83D\uDC17");
        put(Buffalo.class, "\uD83D\uDC03");
        put(Duck.class, "\uD83E\uDD86");
        put(Caterpillar.class, "\uD83D\uDC1B");
    }};

    public static HashMap<Class, String> getClassIcons() {
        return CLASS_ICONS;
    }
}


