import java.util.ArrayList;


public class Zoo implements Subject {
    private static Zoo instance = null;
    ArrayList<Animal> animals;
    ArrayList<ZooObserver> zooObservers;
    int happinessLevel = 2;
    int hungerLevel = 3;
    ArrayList<Pair> pairs = new ArrayList<>();

    /**
     *
     */
    private Zoo() {
        animals = new ArrayList<>();
        zooObservers = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public static Zoo getInstance() {
        if (instance == null) {
            System.out.println("Creating zoo...");
            instance = new Zoo();
        } else {
            System.out.println("The zoo already exists...");
        }
        return instance;
    }

    /**
     *
     * @param list
     */
    public void sortPair(ArrayList<Pair> list) {
        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(i).getAnimalName().compareTo(list.get(j).getAnimalName()) > 0) {
                    Pair temp = list.get(i);
                    list.set(i, new Pair(list.get(j).getAnimalName(), list.get(j).getAnimals()));
                    list.set(j, new Pair(temp.getAnimalName(), temp.getAnimals()));
                }
    }

    /**
     *
     */
    public void showAnimalsInfo() {
        System.out.println("The zoo contains total of " + this.animals.size() + " animals:");
        sortPair(pairs);

        for (Pair p : pairs)
            System.out.println("- " + p.getAnimalName() + ": " + p.getAnimals().size());

        System.out.println("Happiness level: " + this.happinessLevel);
        if (this.happinessLevel < 3)
            System.out.println("The animals are not happy, you should watch them...");
        else
            System.out.println("The animals are very happy, keep working hard...");

        System.out.println("Hunger level: " + this.hungerLevel);
        if (this.hungerLevel > 3)
            System.out.println("The animals are hungry, you should feed them...");
    }

    /**
     *
     * @param animal
     * @param first
     */
    public void addAnimalRecursive(Animal animal, Boolean first) {

        if (first)
            this.animals.add(animal);
        for (Pair p : pairs)
            if (p.getAnimalName().equals(animal.getClass().getSimpleName())) {
                p.addAnimal(animal);
                notifyObservers(animal.getClass().getSimpleName() + " has been added to the zoo!");
                return;
            }
        pairs.add(new Pair(animal.getClass().getSimpleName()));
        addAnimalRecursive(animal, false);
    }

    /**
     *
     * @param animal
     */
    public void addAnimal(Animal animal) {

        addAnimalRecursive(animal, true);
    }

    /**
     *
     */
    public void watchAnimals() {
        if (this.happinessLevel < 5)
            this.happinessLevel++;
        if (this.hungerLevel < 5)
            this.hungerLevel++;
        for (Animal a : animals)
            a.performAction();
        notifyObservers("The animals are being watched");

    }

    /**
     *
     */
    public void feedAnimals() {
        if (this.hungerLevel > 1)
            this.hungerLevel--;
        for (Animal a : animals)
            a.eat();
        notifyObservers("The animals are being fed");
    }

    /**
     *
     * @param observer
     */
    public void removeObserver(Observer observer) {
        this.zooObservers.remove(observer);
    }

    /**
     *
     * @param observer
     */
    public void addObserver(Observer observer) {
        this.zooObservers.add((ZooObserver) observer);
    }

    /**
     *
     * @param desc
     */
    @Override
    public void notifyObservers(String desc) {
        System.out.println("Notifying observers:");
        for (ZooObserver observer : zooObservers) {
            observer.update(desc);
        }
    }
}

