package combatlogproject.filesystem;

/**
 *
 * @author Marc
 */
public class Unit {

    private String name;

    public Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Unit) obj).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
