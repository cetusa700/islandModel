package DrMoroIsland.Animals.Animal.Predator;

import DrMoroIsland.Animals.Animal.Animal;
import DrMoroIsland.Animals.EdibleAnimals;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;

public abstract class Predator extends Animal implements EdibleAnimals {


    public Predator(LocationCoordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void eat() {
        float victimWeight = this.hunting(getCoordinatesOnIsland());
        this.increaseSatiety(victimWeight);
    }
}
