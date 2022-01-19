import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Zoo implements Subject {
    private static Zoo instance = null;
    ArrayList<Animal> animals;
    ArrayList<ZooObserver> zooObservers;
    int happinessLevel = 2;
    int hungerLevel = 3;
     ArrayList<Pair> pairs=new ArrayList<>();

    private String desc;

    //String desc;
    private Zoo() {
        animals = new ArrayList<>();
        zooObservers = new ArrayList<>();
    }

    public static Zoo getInstance() {
        if (instance == null) {
            System.out.println("Creating zoo...");
            instance = new Zoo();
        } else {
            System.out.println("The zoo already exists...");
        }
        return instance;
    }

    public int countAnimal(String name) {
        int counter = 0;
        for (int i = 0; i < this.animals.size(); i++) {
            if (this.animals.get(i).getClass().getSimpleName().equals(name)) {
                counter++;
            }

        }
        return counter;
    }
    public int compare(Animal a1, Animal a2) {
        return a1.getClass().getSimpleName().compareToIgnoreCase(a2.getClass().getSimpleName());
    }
        public void showAnimalsInfo () {

            System.out.println("This zoo contains total of " + this.animals.size() + " animals:");
            for (Pair p : pairs)
                System.out.println("- "+p.animalName + ": " + p.animals.size());
            System.out.println("Happiness level: "+this.happinessLevel);
            if(this.happinessLevel<3)
                System.out.println("The animals are not happy, you should watch them...");
            else
                System.out.println("The animals are very happy, keep working hard...");
            System.out.println("Hungry level: "+this.hungerLevel);
           // Comparator<Animal> comparatorField;
            //animals.sort(new NameSorter());
            //Collections.sort((animals, Comparator.comparing(::getClass)));


        }


        public void addAnimal (Animal animal){

            this.animals.add(animal);
            for (Pair p:pairs)
            {

                if(p.animalName.equals(animal.getClass().getSimpleName()))
                {
                    p.animals.add(animal);
                    notifyObservers(animal.getClass().getSimpleName()+" has been added to the zoo!");
                    return;
                }

            }
            pairs.add(new Pair(animal.getClass().getSimpleName()));
            addAnimal(animal);


        }


        public void watchAnimals () {
        this.happinessLevel++;
        this.hungerLevel++;
        for(Animal a:animals)
            a.performAction();
        }

        ;

        public void feedAnimals () {
            this.hungerLevel--;
            for(Animal a:animals)
                a.eat();
        }

        ;

        public void removeObserver (Observer observer){
            this.zooObservers.remove(observer);
        }

        ;

        public void addObserver (Observer observer){
            this.zooObservers.add((ZooObserver) observer);
        }





        @Override
        public void notifyObservers (String desc)
        {
            System.out.println("Notifying observers:");
            for(ZooObserver observer:zooObservers )
            {
                observer.update(desc);
            }
        }



}

