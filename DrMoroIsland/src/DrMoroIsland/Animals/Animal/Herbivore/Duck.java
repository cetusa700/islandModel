package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.Edible;
import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 200, maxAnimalSteps = 4, maxAnimalSatiety = 0.15f, animalWeight = 1)
public class Duck extends Herbivore implements Edible {

    public Duck(LocationCoordinates coordinates) {
        super(coordinates);
    }


    @Override
    public void eat() {
        float weightOfEatenFood = this.eatSmth(getCoordinatesOnIsland(), getCurrentSatiety());
        this.increaseSatiety(weightOfEatenFood);
    }


}
