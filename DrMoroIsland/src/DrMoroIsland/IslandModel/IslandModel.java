package DrMoroIsland.IslandModel;

import DrMoroIsland.IslandModel.Island.AnimalPopulation;
import DrMoroIsland.IslandModel.Island.Island;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class IslandModel {
    private static Island myIsland;

    public static void islandCreate(int islandWidth, int islandHeight, HashMap<Class, Integer> appearedAnimals) throws Exception {
        myIsland = new Island(islandWidth, islandHeight);
        myIsland.prepareIslands(appearedAnimals);

    }

    public static Island getIsland() {
        return myIsland;
    }

    public static ConcurrentHashMap<Class, AnimalPopulation> getIslandPopulationMap() {
        return myIsland.getPopulationMap();
    }




}
