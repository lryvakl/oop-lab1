package flowershop.model.flower;

import flowershop.model.color.ColorTone;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Lily extends Flower {
    public Lily(ColorTone color, LocalDate harvestDate, double stemLengthCm, BigDecimal price) {
        super("Lily", color, harvestDate, stemLengthCm, price);
    }
    @Override
    public Flower copy() {
        return new Lily(getColor(), getHarvestDate(), getStemLengthCm(), getPrice());
    }
}
