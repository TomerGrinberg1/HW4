public class Zebra  implements Animal{

    /**
     * notifies observers that the animal is putting a show
     */
    @Override
    public void performAction() {
        System.out.println("The zebra is running...");
    }

    /**
     * notifies observers that the animal is being fed
     */
    @Override
    public void eat() {
        System.out.println("The zebra is eating grass...");
    }
}