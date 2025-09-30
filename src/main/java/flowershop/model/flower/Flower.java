package flowershop.model.flower;

import flowershop.model.color.ColorTone;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Flower {
    private final String name;
    private final ColorTone color;
    private final LocalDate harvestDate;
    private final double stemLengthCm;
    private final BigDecimal price;

    protected Flower(String name, ColorTone color, LocalDate harvestDate, double stemLengthCm, BigDecimal price) {
        this.name = name;
        this.color = color;
        this.harvestDate = harvestDate;
        this.stemLengthCm = stemLengthCm;
        this.price = price;
    }

    public String getName() { return name; }
    public ColorTone getColor() { return color; }
    public LocalDate getHarvestDate() { return harvestDate; }
    public double getStemLengthCm() { return stemLengthCm; }
    public BigDecimal getPrice() { return price; }

    public int freshnessDays() {
        return (int) ChronoUnit.DAYS.between(harvestDate, LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("%s [%s], stem=%.1fcm, price=%s, harvested=%s, freshness=%dd",
                name, color, stemLengthCm, price, harvestDate, freshnessDays());
    }
}
