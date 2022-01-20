
public class UnicornFactory extends AnimalFactory{
    /**
     *
     * @return
     */
    @Override
    public Animal createAnimal() {
        return new Unicorn();
    }
}
