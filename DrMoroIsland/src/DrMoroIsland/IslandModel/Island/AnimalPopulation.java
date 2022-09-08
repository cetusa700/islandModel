package DrMoroIsland.IslandModel.Island;

import DrMoroIsland.Animals.Animal.Animal;
import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.IslandModel;
import DrMoroIsland.IslandModel.Randomizer;
import DrMoroIsland.IslandGuide.IconsGuide;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnimalPopulation<T extends Animal> {
    private CopyOnWriteArrayList<T> population;
    private int populationCounter;
    private Class clazz;

    public AnimalPopulation(Class clazz) {
        this.clazz = clazz;
        this.population = new CopyOnWriteArrayList<>();
        this.populationCounter = 0;
    }

    public void populationGrowth(T animal) {
        population.add(animal);
        populationCounter++;
    }

    public void appearanceAnimal(int countOfAppearedEntities) throws Exception {
        for (int i = 0; i < countOfAppearedEntities; i++) {
            LocationCoordinates randomCoordinates = new Randomizer().getRandomCoordinates(clazz);
            Constructor<?> animalConstructor = clazz.getConstructor(LocationCoordinates.class);
            animalConstructor.newInstance(randomCoordinates);
        }
    }

    private void birthAnimal(int countOfAppearedEntities, LocationCoordinates locationCoordinates) throws Exception {
        for (int i = 0; i < countOfAppearedEntities; i++) {
            Constructor<?> animalConstructor = clazz.getConstructor(LocationCoordinates.class);
            animalConstructor.newInstance(locationCoordinates);
        }
    }

    public void animalsMove() {
        for (T oneAnimal : population) {
            oneAnimal.transition();
        }
    }

    public void animalReproduction() throws Exception {
        if (population.size() == 0) {
            return;
        }
        for (int i = 0; i < IslandModel.getIsland().getIslandHeight(); i++) {
            for (int j = 0; j < IslandModel.getIsland().getIslandWidth(); j++) {
                LocationCoordinates locationCoordinates = new LocationCoordinates();
                locationCoordinates.latitude = j;
                locationCoordinates.longitude = i;
                int countOfSameAnimal = Location.getLocationByCoordinates(locationCoordinates).getCountOfSameAnimal(clazz);

                if (countOfSameAnimal < 2) {
                    continue;
                }

                AnimalParameters annotations = (AnimalParameters) clazz.getAnnotation(AnimalParameters.class);
                int possibleCountOfNewAnimal = annotations.maxAnimalCount() - countOfSameAnimal;
                if (countOfSameAnimal / 2 < possibleCountOfNewAnimal) {
                    possibleCountOfNewAnimal = countOfSameAnimal / 2;
                }

                int countOfNewbornAnimals = 0;

                if (possibleCountOfNewAnimal != 0) {
                    countOfNewbornAnimals = new Random().nextInt(possibleCountOfNewAnimal + 1);
                }

                if (countOfNewbornAnimals != 0) {
                    birthAnimal(countOfNewbornAnimals, locationCoordinates);
                }
            }
        }
    }

    public void animalEat(LocationCoordinates locCoordinates) {
        if (Location.getLocationByCoordinates(locCoordinates).getAnimalsOnLocation(clazz) == null) {
            return;
        }
        ArrayList<Animal> animalsOnLocation = Location.getLocationByCoordinates(locCoordinates).getAnimalsOnLocation(clazz);
        Collections.shuffle(animalsOnLocation);
        for (Animal someAnimal : animalsOnLocation) {
            someAnimal.checkSatiety();
        }
    }

    public void populationDecrease(Animal animal) {

        population.remove(animal);
        populationCounter--;

        if (populationCounter == 0) {
            System.out.println(IconsGuide.getClassIcons().get(clazz) + " - the animal population is extinct...");
            IslandModel.getIsland().animalPopulationIsDisappear(clazz);
        }
    }

    public int getPopulationCounter() {
        return populationCounter;
    }
}
