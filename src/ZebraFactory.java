
public class ZebraFactory extends AnimalFactory {
    /**
     *
     * @return instance of a Zebra
     */
    @Override
    public Animal createAnimal() {
        return new Zebra();
    }
}
