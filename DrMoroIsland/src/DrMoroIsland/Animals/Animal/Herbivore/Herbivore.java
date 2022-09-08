package DrMoroIsland.Animals.Animal.Herbivore;

import DrMoroIsland.Animals.Animal.Animal;
import DrMoroIsland.Animals.EdiblePlants;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

public abstract class Herbivore extends Animal implements EdiblePlants {


    public Herbivore(LocationCoordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void eat() {
        float weightOfEatenFood = this.plantEat(getCoordinatesOnIsland(), getCurrentSatiety());
        this.increaseSatiety(weightOfEatenFood);
    }

}
