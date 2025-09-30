package flowershop.flower;
import flowershop.color.ColorTone;
import flowershop.color.RedTone;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {

    private static class TestFlower extends Flower {
        public TestFlower(String name, ColorTone color, LocalDate harvestDate, double stemLengthCm, BigDecimal price) {
            super(name, color, harvestDate, stemLengthCm, price);
        }

        @Override
        public Flower copy() {
            return new TestFlower(getName(), getColor(), getHarvestDate(), getStemLengthCm(), getPrice());
        }
    }

    @Test
    void testFlowerCreation() {
        LocalDate harvestDate = LocalDate.now().minusDays(2);
        ColorTone redColor = new RedTone();
        Flower flower = new TestFlower("Test", redColor, harvestDate, 50.0, new BigDecimal("45.00"));

        assertEquals("Test", flower.getName());
        assertEquals(redColor, flower.getColor());
        assertEquals(harvestDate, flower.getHarvestDate());
        assertEquals(50.0, flower.getStemLengthCm(), 0.001);
        assertEquals(new BigDecimal("45.00"), flower.getPrice());
    }

    @Test
    void testFreshnessDays() {
        LocalDate harvestDate = LocalDate.now().minusDays(3);
        ColorTone redColor = new RedTone();
        Flower flower = new TestFlower("Test", redColor, harvestDate, 50.0, new BigDecimal("45.00"));

        assertEquals(3, flower.freshnessDays());
    }

    @Test
    void testToString() {
        LocalDate harvestDate = LocalDate.now().minusDays(1);
        ColorTone redColor = new RedTone();
        Flower flower = new TestFlower("Test", redColor, harvestDate, 50.0, new BigDecimal("45.00"));

        String result = flower.toString();
        System.out.println("Actual toString result: " + result);
        assertTrue(result.contains("Test"), "Should contain flower name");
        assertTrue(result.contains("45.00"), "Should contain price");
        assertTrue(result.contains("1"), "Should contain freshness days");
        assertTrue(result.contains("Red"), "Should contain color");
        boolean hasStemLength = result.contains("50.0") || result.contains("50,0") || result.contains("50");
        assertTrue(hasStemLength, "Should contain stem length. Actual: " + result);
        assertTrue(result.contains("stem="), "Should contain 'stem='");
        assertTrue(result.contains("cm"), "Should contain 'cm'");
    }

    @Test
    void testCopy() {
        LocalDate harvestDate = LocalDate.now().minusDays(2);
        ColorTone redColor = new RedTone();
        Flower original = new TestFlower("Test", redColor, harvestDate, 50.0, new BigDecimal("45.00"));
        Flower copy = original.copy();

        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getColor(), copy.getColor());
        assertEquals(original.getHarvestDate(), copy.getHarvestDate());
        assertEquals(original.getStemLengthCm(), copy.getStemLengthCm(), 0.001);
        assertEquals(original.getPrice(), copy.getPrice());
    }
}