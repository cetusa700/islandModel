package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;
import DrMoroIsland.IslandModel.Island.Location;

import java.util.Random;

@AnimalParameters(maxAnimalCount = 1000, maxAnimalSteps = 0, maxAnimalSatiety = 0, animalWeight = 0.01f)
public class Caterpillar extends Herbivore {
    public Caterpillar(LocationCoordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void transition() {
    }

    @Override
    public void checkSatiety() {
       eat();
    }

    @Override
    public void eat() {
        float eatenFood = plantEat(getCoordinatesOnIsland(), getCurrentSatiety());
        if (eatenFood == 0 && new Random().nextBoolean()) {
            this.decease();
        }

    }

    @Override
    public float plantEat(LocationCoordinates coordinates, float currentSatiety) {
        int plantsCount = Location.getLocationByCoordinates(coordinates).getPlantsCount();

        if (plantsCount > 0 && new Random().nextBoolean()) {
                Location.getLocationByCoordinates(coordinates).plantDecrease(1);
                return 1;
        }
        return 0;
    }
}
