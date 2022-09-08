package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 140, maxAnimalSteps = 3, maxAnimalSatiety = 15, animalWeight = 70)
public class Sheep extends Herbivore{
    public Sheep(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
