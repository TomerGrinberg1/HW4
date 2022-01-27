public class MonkeyFactory extends AnimalFactory{
    /**
     *
     * @return instance of a Monkey
     */
    @Override
    public Animal createAnimal() {
        return new Monkey();
    }
}