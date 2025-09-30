package flowershop.flower;

import flowershop.color.RedTone;
import flowershop.color.PinkTone;
import flowershop.color.ColorTone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class RoseTest {

    private Rose roseWithThorns;
    private Rose roseWithoutThorns;

    @BeforeEach
    void setUp() {
        LocalDate harvestDate = LocalDate.now().minusDays(2);
        ColorTone redColor = new RedTone();
        ColorTone whiteColor = new PinkTone();

        roseWithThorns = new Rose(redColor, harvestDate, 50.0, new BigDecimal("45.00"), true);
        roseWithoutThorns = new Rose(whiteColor, harvestDate.plusDays(1), 45.0, new BigDecimal("40.00"), false);
    }

    @Test
    void testRoseCreationWithThorns() {
        assertEquals("Rose", roseWithThorns.getName());
        assertTrue(roseWithThorns.getColor() instanceof RedTone);
        assertEquals(50.0, roseWithThorns.getStemLengthCm(), 0.001);
        assertEquals(new BigDecimal("45.00"), roseWithThorns.getPrice());
        assertTrue(roseWithThorns.hasThorns());
    }

    @Test
    void testRoseCreationWithoutThorns() {
        assertEquals("Rose", roseWithoutThorns.getName());
        assertTrue(roseWithoutThorns.getColor() instanceof PinkTone);
        assertEquals(45.0, roseWithoutThorns.getStemLengthCm(), 0.001);
        assertEquals(new BigDecimal("40.00"), roseWithoutThorns.getPrice());
        assertFalse(roseWithoutThorns.hasThorns());
    }

    @Test
    void testRoseCopy() {
        Rose copy = (Rose) roseWithThorns.copy();

        assertEquals(roseWithThorns.getName(), copy.getName());
        assertEquals(roseWithThorns.getColor(), copy.getColor());
        assertEquals(roseWithThorns.getHarvestDate(), copy.getHarvestDate());
        assertEquals(roseWithThorns.getStemLengthCm(), copy.getStemLengthCm(), 0.001);
        assertEquals(roseWithThorns.getPrice(), copy.getPrice());
        assertEquals(roseWithThorns.hasThorns(), copy.hasThorns());

        assertNotSame(roseWithThorns, copy);
    }

    @Test
    void testRoseFreshnessDays() {
        LocalDate harvestDate = LocalDate.now().minusDays(3);
        ColorTone redColor = new RedTone();
        Rose rose = new Rose(redColor, harvestDate, 50.0, new BigDecimal("45.00"), true);

        assertEquals(3, rose.freshnessDays());
    }

    @Test
    void testRoseToStringWithThorns() {
        String result = roseWithThorns.toString();
        System.out.println("Rose with thorns toString: " + result);

        assertTrue(result.contains("Rose"));
        assertTrue(result.contains("Red"));
        assertTrue(result.contains("thorns=yes"));
        assertTrue(result.contains("45.00"));
    }

    @Test
    void testRoseToStringWithoutThorns() {
        String result = roseWithoutThorns.toString();
        System.out.println("Rose without thorns toString: " + result);

        assertTrue(result.contains("Rose"));
        assertTrue(result.contains("Pink"));
        assertTrue(result.contains("thorns=no"));
        assertTrue(result.contains("40.00"));
    }
}