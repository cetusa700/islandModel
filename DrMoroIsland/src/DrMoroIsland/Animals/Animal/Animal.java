package DrMoroIsland.Animals.Animal;

import DrMoroIsland.Animals.AnimalParameters;
import DrMoroIsland.IslandModel.*;
import DrMoroIsland.IslandModel.Island.LocationCoordinates;
import DrMoroIsland.IslandModel.Island.Location;

public abstract class Animal {
    private LocationCoordinates coordinatesOnIsland;
    private float currentSatiety;

    public Animal(LocationCoordinates coordinates) {
        this.coordinatesOnIsland = coordinates;
        this.currentSatiety = this.getClass().getAnnotation(AnimalParameters.class).maxAnimalSatiety();
        appearOnIsland();
    }

    public float getCurrentSatiety() {
        return currentSatiety;
    }

    public LocationCoordinates getCoordinatesOnIsland() {
        return coordinatesOnIsland;
    }

    private void appearOnIsland() {
        IslandModel.getIsland().getPopulationMap().get(this.getClass()).populationGrowth(this);
        addToLocation();
    }

    //
    public void transition() {
        this.decreaseSatiety();

        LocationCoordinates nextCoordinates = new Randomizer().getRandomTransferCoordinate(this);

        if (coordinatesOnIsland.latitude != nextCoordinates.latitude || coordinatesOnIsland.longitude != nextCoordinates.longitude) {
            this.leaveLocation();

            coordinatesOnIsland.latitude = nextCoordinates.latitude;
            coordinatesOnIsland.longitude = nextCoordinates.longitude;
            this.addToLocation();
        }
    }

    private void leaveLocation() {
        Location.getLocationByCoordinates(coordinatesOnIsland).deleteFromLocation(this);
    }

    private void addToLocation() {
        Location.getLocationByCoordinates(coordinatesOnIsland).colonizeLocation(this);
    }

    public abstract void eat();

    public void checkSatiety() {
        if (this.currentSatiety <= (this.getClass().getAnnotation(AnimalParameters.class).maxAnimalSatiety()) * 0.9) {
            eat();
        }
    }

    public void decease() {
        if (IslandModel.getIslandPopulationMap().get(this.getClass()) != null) {
            IslandModel.getIslandPopulationMap().get(this.getClass()).populationDecrease(this);
        }

        Location.getLocationByCoordinates(coordinatesOnIsland).deleteFromLocation(this);

    }

    public void increaseSatiety(float increasedWeigh) {
        if ((currentSatiety + increasedWeigh) > this.getClass().getAnnotation(AnimalParameters.class).maxAnimalSatiety()) {
            this.currentSatiety = this.getClass().getAnnotation(AnimalParameters.class).maxAnimalSatiety();
        } else {
            this.currentSatiety += increasedWeigh;
        }
    }

    private void decreaseSatiety() {
        currentSatiety -= currentSatiety * 0.1;
        if (currentSatiety < this.getClass().getAnnotation(AnimalParameters.class).maxAnimalSatiety() * 0.1) {
            this.decease();
        }
    }
}
