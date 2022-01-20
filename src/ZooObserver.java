public class ZooObserver implements Observer {
    private String name;

    /**
     *
     * @param name
     */
    public ZooObserver(String name){
        this.name=name;

    }
    /**
     *
     * @param desc
     */
    @Override
    public void update(String desc) {
        System.out.println("[" + name + "] " + desc);

    }


}
