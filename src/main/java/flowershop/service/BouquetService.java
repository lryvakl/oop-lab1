package flowershop.service;
import flowershop.accessory.Accessory;
import flowershop.flower.Flower;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BouquetService {
    private final List<Flower> flowers = new ArrayList<>();
    private final List<Accessory> accessories = new ArrayList<>();


    public void addFlower(Flower flower, int quantity) {
        for (int i = 0; i < quantity; i++) {
            flowers.add(flower.copy());
        }
    }

    public void addAccessory(Accessory accessory) { accessories.add(accessory); }

    public List<Flower> getFlowers() { return new ArrayList<>(flowers); }
    public List<Accessory> getAccessories() { return new ArrayList<>(accessories); }

    public BigDecimal calculateTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (Flower f : flowers) total = total.add(f.getPrice());
        for (Accessory a : accessories) total = total.add(a.getPrice());
        return total;
    }

    public void sortByFreshnessAscending() {
        flowers.sort(Comparator.comparingInt(Flower::freshnessDays));
    }

    public List<Flower> findByStemRange(double min, double max) {
        return flowers.stream()
                .filter(f -> f.getStemLengthCm() >= min && f.getStemLengthCm() <= max)
                .collect(Collectors.toList());
    }
}
