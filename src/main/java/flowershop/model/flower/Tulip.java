package flowershop.model.flower;

import flowershop.model.color.ColorTone;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Tulip extends Flower {
    public Tulip(ColorTone color, LocalDate harvestDate, double stemLengthCm, BigDecimal price) {
        super("Tulip", color, harvestDate, stemLengthCm, price);
    }
}
