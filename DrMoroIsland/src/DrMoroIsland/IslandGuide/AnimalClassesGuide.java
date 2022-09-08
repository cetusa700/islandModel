package DrMoroIsland.IslandGuide;

import DrMoroIsland.Animals.Animal.Herbivore.*;
import DrMoroIsland.Animals.Animal.Predator.*;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimalClassesGuide {

    private final static HashMap<String, Class> ANIMAL_CLASSES_FOR_XMLFILE = new HashMap<>() {{
        put("Wolf", Wolf.class);
        put("Boa", Boa.class);
        put("Fox", Fox.class);
        put("Bear", Bear.class);
        put("Eagle", Eagle.class);
        put("Horse", Horse.class);
        put("Deer", Deer.class);
        put("Rabbit", Rabbit.class);
        put("Mouse", Mouse.class);
        put("Goat", Goat.class);
        put("Sheep", Sheep.class);
        put("Boar", Boar.class);
        put("Buffalo", Buffalo.class);
        put("Duck", Duck.class);
        put("Caterpillar", Caterpillar.class);
    }};

    public static HashMap<String, Class> getAnimalClassesForXmlfile() {
        return ANIMAL_CLASSES_FOR_XMLFILE;
    }

    public static ArrayList<Class> getAnimalClasses() {
        return new ArrayList<>(ANIMAL_CLASSES_FOR_XMLFILE.values());
    }



}