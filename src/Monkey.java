public class Monkey  implements Animal  {

    /**
     * notifies observers that the animal is putting a show
     */
    @Override
    public void performAction() {
        System.out.println("The monkey is hanging on trees...");
    }

    /**
     * notifies observers that the animal is being fed
     */
    @Override
    public void eat() {
        System.out.println("The monkey is eating a banana...");
    }
}