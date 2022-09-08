package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.Edible;
import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 50, maxAnimalSteps = 2, maxAnimalSatiety = 50, animalWeight = 400)
public class Boar extends Herbivore implements Edible {
    public Boar(LocationCoordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void eat() {
        float weightOfEatenFood = this.eatSmth(getCoordinatesOnIsland(), getCurrentSatiety());
        this.increaseSatiety(weightOfEatenFood);
    }
}
