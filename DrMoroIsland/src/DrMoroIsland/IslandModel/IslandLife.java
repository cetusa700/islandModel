package DrMoroIsland.IslandModel;

import DrMoroIsland.IslandModel.Island.AnimalPopulation;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;
import DrMoroIsland.IslandModel.Island.Location;
import DrMoroIsland.IslandGuide.IconsGuide;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IslandLife {
    public static boolean isLife = true;

    public static void islandLifeRun() throws Exception {

        plantsGrow();


        while (isLife) {
            timeToMove();
            timeToReproduce();
            timeToEat();
            printStatistic();
        }
    }

    private static void timeToMove() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(IslandModel.getIsland().getPopulationMap().size());
        for (AnimalPopulation onePopulation : IslandModel.getIsland().getPopulationMap().values()) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    onePopulation.animalsMove();
                    countDownLatch.countDown();
                }
            });
        }
        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void timeToReproduce() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(IslandModel.getIsland().getPopulationMap().size());
        for (AnimalPopulation onePopulation : IslandModel.getIsland().getPopulationMap().values()) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        onePopulation.animalReproduction();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        countDownLatch.await();
    }

    private static void timeToEat() {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        CountDownLatch countDownLatch = new CountDownLatch(IslandModel.getIsland().getCountOfLocation());
        for (int i = 0; i < IslandModel.getIsland().getIslandHeight(); i++) {
            for (int j = 0; j < IslandModel.getIsland().getIslandWidth(); j++) {
                LocationCoordinates locCoordinates = new LocationCoordinates();
                locCoordinates.latitude = j;
                locCoordinates.longitude = i;
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        foodExtract(locCoordinates);
                        countDownLatch.countDown();
                    }
                });

            }
        }
        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void foodExtract(LocationCoordinates locCoordinates) {
        for (AnimalPopulation onePopulation : IslandModel.getIsland().getPopulationMap().values()) {
            onePopulation.animalEat(locCoordinates);
        }
    }

    private static void printStatistic() {
        if (IslandModel.getIsland().getPopulationMap().size() != 0) {
            System.out.println("Now Island contains:");
            for (Class animalClass : IslandModel.getIsland().getPopulationMap().keySet()) {
                System.out.print(IconsGuide.getClassIcons().get(animalClass) + " = ");
                System.out.print(IslandModel.getIsland().getPopulationMap().get(animalClass).getPopulationCounter() + "\t");
            }
            System.out.println();

        }


    }

    private static void plantsGrow() {
        Thread growing = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        for (int i = 0; i < IslandModel.getIsland().getIslandHeight(); i++) {
                            for (int j = 0; j < IslandModel.getIsland().getIslandWidth(); j++) {
                                LocationCoordinates locCoordinates = new LocationCoordinates();
                                locCoordinates.latitude = j;
                                locCoordinates.longitude = i;
                                Location.getLocationByCoordinates(locCoordinates).plantIncrease();
                            }
                        }
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        growing.setDaemon(true);
        growing.start();
    }
}
