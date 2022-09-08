package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 150, maxAnimalSteps = 2, maxAnimalSatiety = 0.45f, animalWeight = 2)
public class Rabbit extends Herbivore {

    public Rabbit(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
