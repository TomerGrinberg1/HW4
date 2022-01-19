public class ZooObserver implements Observer {
    private String name;
    private String desc;
    public ZooObserver(String name){
        this.name=name;

    }

    @Override
    public void update(String desc) {
        System.out.println("[" + name + "] " + desc);

    }


}
