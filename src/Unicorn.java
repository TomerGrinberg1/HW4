public class Unicorn implements Animal {

    /**
     * notifies observers that the animal is putting a show
     */
    @Override
    public void performAction() {
        System.out.println("The unicorn is flying...");
    }

    /**
     * notifies observers that the animal is being fed
     */
    @Override
    public void eat() {
        System.out.println("The unicorn is eating rainbow cakes...");
    }
}