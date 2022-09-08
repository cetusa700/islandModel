package DrMoroIsland.IslandModel.Island;

import DrMoroIsland.Animals.Animal.Animal;
import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.IslandModel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Location {
    private volatile ConcurrentHashMap<Class, HashSet<Animal>> locationEntities;
    private int plantsCount;
    private final static int MAX_PLANTS_COUNT = 200;

    public Location() {
        this.locationEntities = new ConcurrentHashMap<Class, HashSet<Animal>>();
    }

    public int getPlantsCount() {
        return plantsCount;
    }

    public void colonizeLocation(Animal animal) {
        if (!locationEntities.containsKey(animal.getClass())) {
            locationEntities.put(animal.getClass(), new HashSet<>());
        }
        locationEntities.get(animal.getClass()).add(animal);
    }

    //
    public void deleteFromLocation(Animal animal) {
        locationEntities.get(animal.getClass()).remove(animal);
    }

    //
    public boolean locationOverpopulationCheck(Class animalClass) {
        if (!animalClass.isAnnotationPresent(AnimalParameters.class)) {
            throw new RuntimeException();
        }
        AnimalParameters annotations = (AnimalParameters) animalClass.getAnnotation(AnimalParameters.class);
        int maxCountOnLocation = annotations.maxAnimalCount();

        return this.locationEntities.containsKey(animalClass) && this.locationEntities.get(animalClass).size() >= maxCountOnLocation;
    }

    public int getCountOfSameAnimal(Class animalClass) {
        if (locationEntities.containsKey(animalClass)) {
            return locationEntities.get(animalClass).size();
        }
        return 0;
    }

    public Animal getFoodOnLocation(ArrayList<Class> animalsForFinding) {
        Collections.shuffle(animalsForFinding);
        for (Class foundAnimal : animalsForFinding) {
            if (locationEntities.containsKey(foundAnimal) && locationEntities.get(foundAnimal).size() > 0) {
                Iterator<Animal> it = locationEntities.get(foundAnimal).iterator();
                return it.next();
            }
        }
        return null;
    }

    public ArrayList<Animal> getAnimalsOnLocation(Class animalClass) {
        if (locationEntities.containsKey(animalClass) && locationEntities.get(animalClass).size() > 0) {
            return new ArrayList<>(locationEntities.get(animalClass));
        }
        return null;
    }

    public void startPlantsGrowth() {
        plantsCount = new Random().nextInt(MAX_PLANTS_COUNT) + 1;
    }

    public void plantDecrease(int decreaseCount) {
        this.plantsCount -= decreaseCount;
    }


    public void plantIncrease() {
        int countPlantsToGrow = MAX_PLANTS_COUNT;

        if (plantsCount > 0) {
            countPlantsToGrow = MAX_PLANTS_COUNT - plantsCount;
        }

        plantsCount = new Random().nextInt(countPlantsToGrow + 1);
    }

    public static Location getLocationByCoordinates(LocationCoordinates coordinates) {
        return IslandModel.getIsland().getLocation(coordinates);
    }

}
