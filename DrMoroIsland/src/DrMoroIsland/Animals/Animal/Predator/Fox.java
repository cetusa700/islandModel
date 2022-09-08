package DrMoroIsland.Animals.Animal.Predator;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 30, maxAnimalSteps = 2, maxAnimalSatiety = 2, animalWeight = 8)
public class Fox extends Predator{
    public Fox(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
