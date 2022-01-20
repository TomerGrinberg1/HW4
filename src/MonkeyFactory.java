public class MonkeyFactory extends AnimalFactory{
    /**
     *
     * @return
     */
    @Override
    public Animal createAnimal() {
        return new Monkey();
    }
}