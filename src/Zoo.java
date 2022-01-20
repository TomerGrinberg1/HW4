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

        public void sortPair(ArrayList<Pair> list)
        {
            for(int i = 0; i<list.size(); i++)   //Holds each element
            {
                for (int j = i+1; j< list.size(); j++)  //Check for remaining elements
                {
                    //compares each element of the array to all the remaining elements
                    if(list.get(i).getAnimalName().compareTo(list.get(j).getAnimalName())>0)
                    {
                        Pair temp = list.get(i);
                        list.set(i,new Pair(list.get(j).getAnimalName(), list.get(j).getAnimals()));
                        list.set(j,new Pair(temp.getAnimalName(), temp.getAnimals()));
                        /*
                        //swapping array elements
                        String tempName = list.get(i).getAnimalName();
                        ArrayList<Animal> tempList=list.get(i).getAnimals();
                        list.get(i).setAnimalName(list.get(j).getAnimalName());
                        list.get(i).animals=list.get(j).getAnimals();
                     //   list.get(i).getAnimalName() = ;
                        list.get(j).setAnimalName(tempName);
                        list.get(i).animals=tempList;
                       // list.get(j).getAnimalName() = temp;
                       */
                    }
                }
            }
        }



    public void showAnimalsInfo () {

            System.out.println("The zoo contains total of " + this.animals.size() + " animals:");
        sortPair(pairs);
            for (Pair p : pairs)
                System.out.println("- "+p.animalName + ": " + p.animals.size());

            System.out.println("Happiness level: "+this.happinessLevel);
            if(this.happinessLevel<3)
                System.out.println("The animals are not happy, you should watch them...");
            else
                System.out.println("The animals are very happy, keep working hard...");
            System.out.println("Hunger level: "+this.hungerLevel);
            if(this.hungerLevel>3)
                System.out.println("The animals are hungry, you should feed them...");
           // Comparator<Animal> comparatorField;
            //animals.sort(new NameSorter());
            //Collections.sort((animals, Comparator.comparing(::getClass)));


        }


        public void addAnimalRecursive(Animal animal, Boolean first){

            if(first)
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
            addAnimalRecursive(animal,false);
        }




        public void addAnimal (Animal animal) {

        addAnimalRecursive(animal,true );
        }

        public void watchAnimals () {
        if(this.happinessLevel<5)
        this.happinessLevel++;
        if(this.hungerLevel<5)
        this.hungerLevel++;
        for(Animal a:animals)
            a.performAction();
        notifyObservers("The animals are being watched");

        }

        public void feedAnimals () {
            if(this.hungerLevel>1)
            this.hungerLevel--;
            for(Animal a:animals)
                a.eat();
            notifyObservers("The animals are being fed");
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

