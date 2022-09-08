package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 20, maxAnimalSteps = 4, maxAnimalSatiety = 50, animalWeight = 300)
public class Deer  extends Herbivore{
    public Deer(LocationCoordinates coordinates) {
        super(coordinates);
    }
}
