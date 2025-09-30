package flowershop.flower;

import flowershop.color.ColorTone;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Lily extends Flower {
    private int petalCount;

    public Lily(ColorTone color, LocalDate harvestDate, double stemLengthCm, BigDecimal price, int petalCount) {
        super("Lily", color, harvestDate, stemLengthCm, price);
        this.petalCount = petalCount;
    }

    public int getPetalCount() { return petalCount; }

    @Override
    public Flower copy() {
        return new Lily(getColor(), getHarvestDate(), getStemLengthCm(), getPrice(), petalCount);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", petals=%d", petalCount);
    }
}