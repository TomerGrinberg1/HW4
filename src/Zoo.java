import java.util.ArrayList;


public class Zoo implements Subject {
    private static Zoo instance = null;
    int happinessLevel = 2;
    int hungerLevel = 3;
    static final int HAPPINESS_BAR = 3;
    static final int MAX_HAPPINESS = 5;
    static final int MIN_HUNGER = 1;
    ArrayList<Pair> pairs = new ArrayList<>();
    ArrayList<Animal> animals;
    ArrayList<ZooObserver> zooObservers;

    /**
     *class constructor
     * set as private as part of the Singelton design-pattern
     */
    protected Zoo() {
        animals = new ArrayList<>();
        zooObservers = new ArrayList<>();
    }

    /**
     * creates a zoo instance if one is not already exist
     * @return zoo instance, null is the Singelton is already has been created
     */
    protected static Zoo getInstance() {
        if (instance == null) {
            System.out.println("Creating zoo...");
            instance = new Zoo();
        } else {
            System.out.println("The zoo already exists...");
        }
        return instance;
    }

    /**
     * sorts the animals by an alphabetic order
     * @param list pairs of animal' name and a list of all its' instances
     */
    protected void sortPair(ArrayList<Pair> list) {
        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(i).getAnimalName().compareTo(
                        list.get(j).getAnimalName()) > 0) {
                    Pair temp = list.get(i);
                    list.set(i, new Pair(list.get(j).getAnimalName(),
                            list.get(j).getAnimals()));
                    list.set(j, new Pair(temp.getAnimalName(),
                            temp.getAnimals()));
                }
    }

    /**
     * print a quick preview on the animals' overall quantity, hunger and happiness level
     */
    protected void showAnimalsInfo() {
        System.out.println("The zoo contains total of " +
                this.animals.size() + " animals:");
        sortPair(pairs);

        for (Pair p : pairs)
            System.out.println("- " + p.getAnimalName() +
                    ": " + p.getAnimals().size());

        System.out.println("Happiness level: " + this.happinessLevel);
        if (this.happinessLevel < HAPPINESS_BAR)
            System.out.println(
                    "The animals are not happy, you should watch them...");
        else
            System.out.println(
                    "The animals are very happy, keep working hard...");

        System.out.println("Hunger level: " + this.hungerLevel);
        if (this.hungerLevel > HAPPINESS_BAR)
            System.out.println(
                    "The animals are hungry, you should feed them...");
    }

    /**
     * adds a new animal instance to the animal-pairs list,
     * is the breed does not appear in the list yet, it creates new pair
     * @param animal Animal instance
     * @param first decides if new pair is need to be created
     */
    protected void addAnimalRecursive(Animal animal, Boolean first) {

        if (first)
            this.animals.add(animal);
        for (Pair p : pairs)
            if (p.getAnimalName().equals(animal.getClass().getSimpleName())) {
                p.addAnimal(animal);
                notifyObservers(animal.getClass().getSimpleName() +
                        " has been added to the zoo!");
                return;
            }
        pairs.add(new Pair(animal.getClass().getSimpleName()));
        addAnimalRecursive(animal, false);
    }

    /**
     *  adds the Animal instance to the pairs list, coat method
     * @param animal Animal instance
     */
    protected void addAnimal(Animal animal) {

        addAnimalRecursive(animal, true);
    }

    /**
     * activates as a show organizer
     * for every show the hunger and happiness level increases by one
     * each Observer is being notified about the show
     */
    protected void watchAnimals() {
        if (this.happinessLevel < MAX_HAPPINESS)
            this.happinessLevel++;
        if (this.hungerLevel < MAX_HAPPINESS)
            this.hungerLevel++;
        for (Animal a : animals)
            a.performAction();
        notifyObservers("The animals are being watched");

    }

    /**
     * for every feeding the animals' hunger level decries by one
     * each Observer is being notified about the feeding
     */
    protected void feedAnimals() {
        if (this.hungerLevel > MIN_HUNGER)
            this.hungerLevel--;
        for (Animal a : animals)
            a.eat();
        notifyObservers("The animals are being fed");
    }

    /**
     *  unsubscribe an observer from the zoo's notification system
     * @param observer instance of an Observer
     */
    public void removeObserver(Observer observer) {
        this.zooObservers.remove((ZooObserver) observer);
    }

    /**
     *  subscribe a new observer to the zoo's notification system
     * @param observer instance of an Observer
     */
    public void addObserver(Observer observer) {
        this.zooObservers.add((ZooObserver) observer);
    }

    /**
     *  notifies each subscriber on the latest event in the zoo
     * @param desc the message each observer is going to get
     */
    @Override
    public void notifyObservers(String desc) {
        System.out.println("Notifying observers:");
        for (ZooObserver observer : zooObservers) {
            observer.update(desc);
        }
    }
}

