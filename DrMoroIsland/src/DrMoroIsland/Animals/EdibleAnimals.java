package DrMoroIsland.Animals;

import DrMoroIsland.Animals.Animal.Animal;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;
import DrMoroIsland.IslandModel.Island.Location;
import DrMoroIsland.IslandModel.Randomizer;
import DrMoroIsland.IslandGuide.AnimalRationGuide;

import java.util.*;

public interface EdibleAnimals {

    default float hunting(LocationCoordinates coordinates) {
        ArrayList<Class> animalsForFinding = AnimalRationGuide.getWhatAnimalCanToIt(this.getClass());
        Collections.shuffle(animalsForFinding);

        Animal animalForHunt = Location.getLocationByCoordinates(coordinates).getFoodOnLocation(animalsForFinding);

        if (animalForHunt != null) {
            boolean isEat = new Randomizer().getRandomResultOfHunting(this, animalForHunt);

            if (isEat) {
                animalForHunt.decease();
                return animalForHunt.getClass().getAnnotation(AnimalParameters.class).animalWeight();
            }
        }
        return 0f;
    }
}