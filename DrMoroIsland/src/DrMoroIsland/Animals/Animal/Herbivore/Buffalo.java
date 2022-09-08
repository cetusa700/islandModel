package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 10, maxAnimalSteps = 3, maxAnimalSatiety = 100, animalWeight = 700)
public class Buffalo extends Herbivore{
    public Buffalo(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
