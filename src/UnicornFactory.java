
public class UnicornFactory extends AnimalFactory{
    /**
     *
     * @return instance of a Unicorn
     */
    @Override
    public Animal createAnimal() {
        return new Unicorn();
    }
}
