import java.util.ArrayList;

public class Pair {
    private String animalName;
    private ArrayList<Animal> animals;
    /**
     *
     * @param name
     */
    public Pair(String name) {
        this.animalName=name;
        animals=new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param list
     */
    public Pair(String name, ArrayList<Animal> list){
        this.animalName = name;
        animals = new ArrayList<>(list);
    }

    /**
     *
     * @return
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     *
     * @return
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     *
     * @param animal
     */
    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
}
