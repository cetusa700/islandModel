package DrMoroIsland.Animals;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AnimalParameters {
    int maxAnimalCount();
    int maxAnimalSteps();
    float maxAnimalSatiety();
    float animalWeight();
}
