package DrMoroIsland.Animals;


import DrMoroIsland.IslandModel.Island.LocationCoordinates;
import DrMoroIsland.IslandModel.Island.Location;

import java.util.Random;

public interface EdiblePlants {
    default float plantEat(LocationCoordinates coordinates, float currentSatiety) {

        if (!this.getClass().isAnnotationPresent(AnimalParameters.class)) {
            throw new RuntimeException();
        }
        float maxSatiety = this.getClass().getAnnotation(AnimalParameters.class).maxAnimalSatiety();

        int canToEatPlantElse = (int) Math.ceil(maxSatiety - currentSatiety);

        int plantsCount = Location.getLocationByCoordinates(coordinates).getPlantsCount();

        if (canToEatPlantElse > plantsCount) {
            canToEatPlantElse = plantsCount;
        }

        int countOfEatenPlants = 0;
        if (canToEatPlantElse > 0) {
            countOfEatenPlants = new Random().nextInt(canToEatPlantElse + 1);
        }

        Location.getLocationByCoordinates(coordinates).plantDecrease(countOfEatenPlants);

        return countOfEatenPlants;
    }

}
