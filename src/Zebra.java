public class Zebra  implements Animal{

    /**
     *
     */
    @Override
    public void performAction() {
        System.out.println("The zebra is running...");
    }

    /**
     *
     */
    @Override
    public void eat()
    {
        System.out.println("The zebra is eating grass...");
    }
}