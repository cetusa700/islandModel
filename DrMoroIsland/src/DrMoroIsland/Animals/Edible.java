package DrMoroIsland.Animals;

import DrMoroIsland.IslandModel.Island.LocationCoordinates;

import java.util.Random;

public interface Edible extends EdibleAnimals, EdiblePlants {

    default float eatSmth(LocationCoordinates coordinates, float satiety) {
        float countOfEatenFood = 0f;
        if (new Random().nextBoolean()) {
            countOfEatenFood = hunting(coordinates);
        }
        if (countOfEatenFood == 0) {
            countOfEatenFood = plantEat(coordinates, satiety);
        }
        return countOfEatenFood;
    }

}
