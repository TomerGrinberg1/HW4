import java.util.ArrayList;

public class Pair {
    private final String animalName;
    private ArrayList<Animal> animals;
    /**
     *  class constructor.
     *  creates a pair by the animal's name with empty instances list
     * @param name animal's name
     */
    protected Pair(String name) {
        this.animalName=name;
        animals=new ArrayList<>();
    }

    /**
     *  class constructor.
     *  creates a new pair by the animals name and all of its instances
     * @param name animal's name
     * @param list all the instances in the zoo from the same breed
     */
    protected Pair(String name, ArrayList<Animal> list){
        this.animalName = name;
        animals = new ArrayList<>(list);
    }

    /**
     * @return the name of the breed's list
     */
    protected String getAnimalName() {
        return animalName;
    }

    /**
     * @return list of all the instances from the animal's breed in the zoo
     */
    protected ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * adding a new instance to the zoo
     * @param animal new instance
     */
    protected void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
}
