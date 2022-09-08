package DrMoroIsland.Animals.Animal.Predator;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 20, maxAnimalSteps = 3, maxAnimalSatiety = 1, animalWeight = 6)
public class Eagle extends Predator{
    public Eagle(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
