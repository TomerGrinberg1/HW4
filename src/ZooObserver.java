public class ZooObserver implements Observer {
    private String name;

    /**
     * class constructor
     * @param name observer's name(
     */
    public ZooObserver(String name){
        this.name=name;

    }
    /**
     * notifies each observer on the latest event occurred in the zoo
     * @param desc event's info
     *
     */
    @Override
    public void update(String desc) {
        System.out.println("[" + name + "] " + desc);

    }


}
