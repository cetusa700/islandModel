package DrMoroIsland.Animals.Animal.Predator;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 30, maxAnimalSteps = 1, maxAnimalSatiety = 3, animalWeight = 15)
public class Boa extends Predator {
    public Boa(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
