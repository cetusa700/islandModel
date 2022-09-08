package DrMoroIsland.IslandGuide;

import DrMoroIsland.Animals.Animal.Herbivore.*;
import DrMoroIsland.Animals.Animal.Predator.*;

import java.util.*;

public class AnimalRationGuide {
    private final static HashMap<Class,HashMap<Class, Integer>> ANIMALS_FOOD_RATION;

    static {
        ANIMALS_FOOD_RATION = new HashMap<>();

        ANIMALS_FOOD_RATION.put(Wolf.class, new HashMap<>() {{
            put(Horse.class, 10);
            put(Deer.class,15);
            put(Rabbit.class, 60);
            put(Mouse.class, 80);
            put(Goat.class, 60);
            put(Sheep.class,70);
            put(Boar.class, 15);
            put(Buffalo.class, 10);
            put(Duck.class, 40);
        }});

        ANIMALS_FOOD_RATION.put(Boa.class, new HashMap<>() {{
            put(Fox.class, 15);
            put(Rabbit.class,20);
            put(Mouse.class,40);
            put(Duck.class, 10);
        }});

        ANIMALS_FOOD_RATION.put(Fox.class, new HashMap<>() {{
            put(Rabbit.class, 70);
            put(Mouse.class, 90);
            put(Duck.class, 60);
            put(Caterpillar.class, 40);
        }});

        ANIMALS_FOOD_RATION.put(Bear.class, new HashMap<>() {{
            put(Boa.class, 80);
            put(Horse.class, 40);
            put(Deer.class, 80);
            put(Rabbit.class, 80);
            put(Mouse.class, 90);
            put(Goat.class, 70);
            put(Sheep.class, 70);
            put(Boar.class, 50);
            put(Buffalo.class, 20);
            put(Duck.class, 10);
        }});

        ANIMALS_FOOD_RATION.put(Eagle.class, new HashMap<>() {{
            put(Fox.class, 10);
            put(Rabbit.class, 90);
            put(Mouse.class, 90);
            put(Duck.class, 80);
        }});

        ANIMALS_FOOD_RATION.put(Mouse.class, new HashMap<>() {{
            put(Caterpillar.class, 90);
        }});

        ANIMALS_FOOD_RATION.put(Boar.class, new HashMap<>() {{
            put(Mouse.class, 50);
            put(Caterpillar.class, 90);
        }});

        ANIMALS_FOOD_RATION.put(Duck.class, new HashMap<>() {{
            put(Caterpillar.class, 90);
        }});


    }

    public static HashMap<Class, Integer> getAnimalFoodRation(Class animalClass) {
        return ANIMALS_FOOD_RATION.get(animalClass);
    }



    public static ArrayList<Class> getWhatAnimalCanToIt(Class animalClass) {
        ArrayList<Class> whatAnimalCanToIt = new ArrayList<>(getAnimalFoodRation(animalClass).keySet());
        return whatAnimalCanToIt;
    }





}
