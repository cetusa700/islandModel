package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 20, maxAnimalSteps = 4, maxAnimalSatiety = 60, animalWeight = 400)
public class Horse extends Herbivore{
    public Horse(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
