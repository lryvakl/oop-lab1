package flowershop.model.flower;

import flowershop.model.color.ColorTone;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Rose extends Flower {
    public Rose(ColorTone color, LocalDate harvestDate, double stemLengthCm, BigDecimal price) {
        super("Rose", color, harvestDate, stemLengthCm, price);
    }
}
