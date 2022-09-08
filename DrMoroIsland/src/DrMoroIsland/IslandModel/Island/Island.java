package DrMoroIsland.IslandModel.Island;

import DrMoroIsland.IslandModel.IslandLife;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Island {
    private Location[][] islandLocations;
    private volatile ConcurrentHashMap<Class, AnimalPopulation> populationMap;

    public Location getLocation(LocationCoordinates coordinates) {
        return islandLocations[coordinates.longitude][coordinates.latitude];
    }

    public int getIslandWidth() {
        return islandLocations[0].length;
    }

    public int getIslandHeight() {
        return islandLocations.length;
    }

    public int getCountOfLocation() {
        return islandLocations.length * islandLocations[0].length;
    }

    public ConcurrentHashMap<Class, AnimalPopulation> getPopulationMap() {
        return populationMap;
    }

    public Island(int width, int height) {
        islandLocations = new Location[height][width];
    }

    public void prepareIslands(HashMap<Class, Integer> appearedAnimals) throws Exception {
        locationsCreate();
        plantsCreate();
        animalCreate(appearedAnimals);
    }

    private void locationsCreate() {
        for (int i = 0; i < islandLocations.length; i++) {
            for (int j = 0; j < islandLocations[0].length; j++) {
                islandLocations[i][j] = new Location();
            }
        }
    }

    private void plantsCreate() {
        for (Location[] islandLocationRow : islandLocations) {
            for (Location islandLocation : islandLocationRow) {
                islandLocation.startPlantsGrowth();
            }
        }
    }

    private void animalCreate(HashMap<Class, Integer> appearedAnimals) throws Exception {
        makePopulationMap(new ArrayList<>(appearedAnimals.keySet()));

        for (var pair : appearedAnimals.entrySet()) {
            Class appearedClass = pair.getKey();
            int countAppearedEntities = pair.getValue();
            populationMap.get(appearedClass).appearanceAnimal(countAppearedEntities);
        }
    }

    private void makePopulationMap(ArrayList<Class> animalClassesOnIsland) {
        populationMap = new ConcurrentHashMap<Class, AnimalPopulation>();
        for (Class clazz : animalClassesOnIsland) {
            populationMap.put(clazz, new AnimalPopulation(clazz));
        }

    }

    public void animalPopulationIsDisappear(Class animalClass) {
        populationMap.remove(animalClass);

        if (populationMap.size() == 0) {
            System.out.println("Island life has just extinct");
            IslandLife.isLife = false;
        }
    }


}
