package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.Edible;
import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

@AnimalParameters(maxAnimalCount = 500, maxAnimalSteps = 1, maxAnimalSatiety = 0.01f, animalWeight = 0.05f)
public class Mouse extends Herbivore implements Edible {
    public Mouse(LocationCoordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void eat() {
        float weightOfEatenFood = this.eatSmth(getCoordinatesOnIsland(), getCurrentSatiety());
        this.increaseSatiety(weightOfEatenFood);
    }
}
