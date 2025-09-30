package flowershop.accessory;
import java.math.BigDecimal;

public abstract class Accessory {
    private final String name;
    private final BigDecimal price;

    protected Accessory(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + price + ")";
    }
}
