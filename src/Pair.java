import java.util.ArrayList;

public class Pair {
    String animalName;
    ArrayList<Animal> animals;

    public String getAnimalName() {
        return animalName;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Pair(String name)
    {
        this.animalName=name;
        animals=new ArrayList<>();
    }
    public void addAnimal(Animal animal)
    {
        this.animals.add(animal);

    }

}
