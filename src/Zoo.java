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
}
