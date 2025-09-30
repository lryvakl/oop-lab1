package flowershop.flower;

import flowershop.color.ColorTone;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Tulip extends Flower {
    private String bulbType;

    public Tulip(ColorTone color, LocalDate harvestDate, double stemLengthCm, BigDecimal price, String bulbType) {
        super("Tulip", color, harvestDate, stemLengthCm, price);
        this.bulbType = bulbType;
    }

    public String getBulbType() { return bulbType; }

    @Override
    public Flower copy() {
        return new Tulip(getColor(), getHarvestDate(), getStemLengthCm(), getPrice(), bulbType);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", bulb=%s", bulbType);
    }
}