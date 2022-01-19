import java.util.Comparator;

public class NameSorter implements Comparator<Animal>
{
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getClass().getSimpleName().compareToIgnoreCase(a2.getClass().getSimpleName());
    }
}