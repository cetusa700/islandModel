package DrMoroIsland.Animals.Animal.Predator;


import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 30, maxAnimalSteps = 3, maxAnimalSatiety = 8, animalWeight = 50)
public class Wolf extends Predator {


    public Wolf(LocationCoordinates coordinates) {
        super(coordinates);
    }





}
