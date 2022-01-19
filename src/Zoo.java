import java.util.ArrayList;

public class Zoo implements Subject {
    ArrayList<Animal> zoo;
    public Zoo(){
        zoo=new ArrayList<>();
    }

    public static Zoo getInstance() {
        return null;
    }

    public void showAnimalsInfo(){};
    public void addAnimal(Animal animal){};
    public void watchAnimals(){};
    public void feedAnimals(){};
    public void removeObserver(ZooObserver observer){};

    public void addObserver(ZooObserver observer){};

    @Override
    public void subscribeObserver(Observer observer) {

    }

    @Override
    public void unsubscribeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public String subjectDetails() {
        return null;
    }
}

