package flowershop.accessory;
import java.math.BigDecimal;

public class WrappingPaper extends Accessory {
    private String material;
    private String pattern;


    public WrappingPaper(String material, BigDecimal price, String pattern) {
        super("Wrapping Paper", price);
        this.material = material;
        this.pattern = pattern;
    }


    public WrappingPaper() {
        this("cellophane", BigDecimal.valueOf(10.0), "floral");
    }

    public String getMaterial() { return material; }
    public String getPattern() { return pattern; }

    @Override
    public String toString() {
        return super.toString() + String.format(" [material=%s, pattern=%s]", material, pattern);
    }
}