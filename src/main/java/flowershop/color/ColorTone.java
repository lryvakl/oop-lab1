package flowershop.color;

public abstract class ColorTone {
    private final String name;

    protected ColorTone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
