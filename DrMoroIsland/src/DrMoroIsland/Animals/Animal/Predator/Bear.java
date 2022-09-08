package DrMoroIsland.Animals.Animal.Predator;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 5, maxAnimalSteps = 2, maxAnimalSatiety = 80, animalWeight = 500)
public class Bear extends Predator{
    public Bear(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
