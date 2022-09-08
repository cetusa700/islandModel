package DrMoroIsland.IslandModel;

import DrMoroIsland.Animals.Animal.Animal;
import DrMoroIsland.Animals.EdibleAnimals;
import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;
import DrMoroIsland.IslandModel.Island.Location;
import DrMoroIsland.IslandGuide.AnimalRationGuide;

import java.util.Random;

public class Randomizer {

    public LocationCoordinates getRandomCoordinates(Class appearedAnimalClass) {
        LocationCoordinates randomCoordinates = new LocationCoordinates();
        boolean isCheck = false;

        while (!isCheck) {
            randomCoordinates.latitude = new Random().nextInt(IslandModel.getIsland().getIslandWidth());
            randomCoordinates.longitude = new Random().nextInt(IslandModel.getIsland().getIslandHeight());

            if (Location.getLocationByCoordinates(randomCoordinates).locationOverpopulationCheck(appearedAnimalClass)) {
                continue;
            }
            isCheck = true;
        }
        return randomCoordinates;
    }

    public LocationCoordinates getRandomTransferCoordinate(Animal animal) {

        if (!animal.getClass().isAnnotationPresent(AnimalParameters.class)) {
            throw new RuntimeException();
        }
        int speed = animal.getClass().getAnnotation(AnimalParameters.class).maxAnimalSteps();

        LocationCoordinates nextCoordinates = animal.getCoordinatesOnIsland();

        boolean isCheck = false;
        int counter = 0;

        while (!isCheck && counter < 20) {     // ????
            LocationCoordinates randomNextCoordinates = new LocationCoordinates();
            randomNextCoordinates.latitude = animal.getCoordinatesOnIsland().latitude;
            randomNextCoordinates.longitude = animal.getCoordinatesOnIsland().longitude;

            int steps = new Random().nextInt(speed) + 1;
            if (!new Random().nextBoolean()) {
                steps *= -1;
            }

            boolean isHorizontal = new Random().nextBoolean();
            if (isHorizontal) {
                randomNextCoordinates.latitude += steps;
            } else {
                randomNextCoordinates.longitude += steps;
            }

            if (randomNextCoordinates.latitude >= IslandModel.getIsland().getIslandWidth() || randomNextCoordinates.latitude < 0) {
                counter++;
                continue;
            }
            if (randomNextCoordinates.longitude >= IslandModel.getIsland().getIslandHeight() || randomNextCoordinates.longitude < 0) {
                counter++;
                continue;
            }
            if (Location.getLocationByCoordinates(randomNextCoordinates).locationOverpopulationCheck(animal.getClass())) {
                counter++;
                continue;
            }

            isCheck = true;
            nextCoordinates = randomNextCoordinates;
        }

        return nextCoordinates;

    }

    public boolean getRandomResultOfHunting(EdibleAnimals animalEatable, Animal animalForHunt) {
        int luckPercent = AnimalRationGuide.getAnimalFoodRation(animalEatable.getClass()).get(animalForHunt.getClass());
        int numberOfLuck = new Random().nextInt(101);
        return (numberOfLuck < luckPercent);
    }
}
