import java.util.ArrayList;

public class Pair {
    String animalName;
    ArrayList<Animal> animals;

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
