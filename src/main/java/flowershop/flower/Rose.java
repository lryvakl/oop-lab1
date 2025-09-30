package flowershop.flower;

import flowershop.color.ColorTone;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Rose extends Flower {
    private boolean hasThorns;

    public Rose(ColorTone color, LocalDate harvestDate, double stemLengthCm, BigDecimal price, boolean hasThorns) {
        super("Rose", color, harvestDate, stemLengthCm, price);
        this.hasThorns = hasThorns;
    }

    public boolean hasThorns() { return hasThorns; }

    @Override
    public Flower copy() {
        return new Rose(getColor(), getHarvestDate(), getStemLengthCm(), getPrice(), hasThorns);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", thorns=%s", hasThorns ? "yes" : "no");
    }
}