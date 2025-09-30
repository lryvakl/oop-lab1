package flowershop.accessory;
import java.math.BigDecimal;

public class Ribbon extends Accessory {
    private String material;
    private double length;


    public Ribbon(String material, BigDecimal price, double length) {
        super("Ribbon", price);
        this.material = material;
        this.length = length;
    }


    public Ribbon() {
        this("satin", BigDecimal.valueOf(15.0), 2.5);
    }

    public String getMaterial() { return material; }
    public double getLength() { return length; }

    @Override
    public String toString() {
        return super.toString() + String.format(" [material=%s, length=%.1fm]", material, length);
    }
}