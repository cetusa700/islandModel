package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 140, maxAnimalSteps = 3, maxAnimalSatiety = 10, animalWeight = 60)
public class Goat extends Herbivore {
    public Goat(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
