package flowershop.flower;

import flowershop.color.YellowTone;
import flowershop.color.PinkTone;
import flowershop.color.ColorTone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class TulipTest {

    private Tulip tulipLargeBulb;
    private Tulip tulipSmallBulb;

    @BeforeEach
    void setUp() {
        LocalDate harvestDate = LocalDate.now().minusDays(3);
        ColorTone yellowColor = new YellowTone();
        ColorTone purpleColor = new PinkTone();

        tulipLargeBulb = new Tulip(yellowColor, harvestDate, 35.0, new BigDecimal("25.00"), "large");
        tulipSmallBulb = new Tulip(purpleColor, harvestDate.minusDays(1), 30.0, new BigDecimal("20.00"), "small");
    }

    @Test
    void testTulipCreationWithLargeBulb() {
        assertEquals("Tulip", tulipLargeBulb.getName());
        assertTrue(tulipLargeBulb.getColor() instanceof YellowTone);
        assertEquals(35.0, tulipLargeBulb.getStemLengthCm(), 0.001);
        assertEquals(new BigDecimal("25.00"), tulipLargeBulb.getPrice());
        assertEquals("large", tulipLargeBulb.getBulbType());
    }

    @Test
    void testTulipCreationWithSmallBulb() {
        assertEquals("Tulip", tulipSmallBulb.getName());
        assertTrue(tulipSmallBulb.getColor() instanceof PinkTone);
        assertEquals(30.0, tulipSmallBulb.getStemLengthCm(), 0.001);
        assertEquals(new BigDecimal("20.00"), tulipSmallBulb.getPrice());
        assertEquals("small", tulipSmallBulb.getBulbType());
    }

    @Test
    void testTulipCopy() {
        Tulip copy = (Tulip) tulipLargeBulb.copy();

        assertEquals(tulipLargeBulb.getName(), copy.getName());
        assertEquals(tulipLargeBulb.getColor(), copy.getColor());
        assertEquals(tulipLargeBulb.getHarvestDate(), copy.getHarvestDate());
        assertEquals(tulipLargeBulb.getStemLengthCm(), copy.getStemLengthCm(), 0.001);
        assertEquals(tulipLargeBulb.getPrice(), copy.getPrice());
        assertEquals(tulipLargeBulb.getBulbType(), copy.getBulbType());

        assertNotSame(tulipLargeBulb, copy);
    }

    @Test
    void testTulipFreshnessDays() {
        LocalDate harvestDate = LocalDate.now().minusDays(4);
        ColorTone yellowColor = new YellowTone();
        Tulip tulip = new Tulip(yellowColor, harvestDate, 35.0, new BigDecimal("25.00"), "medium");

        assertEquals(4, tulip.freshnessDays());
    }

    @Test
    void testTulipToStringWithLargeBulb() {
        String result = tulipLargeBulb.toString();
        System.out.println("Tulip with large bulb toString: " + result);

        assertTrue(result.contains("Tulip"));
        assertTrue(result.contains("Yellow"));
        assertTrue(result.contains("bulb=large"));
        assertTrue(result.contains("25.00"));
    }

    @Test
    void testTulipToStringWithSmallBulb() {
        String result = tulipSmallBulb.toString();
        System.out.println("Tulip with small bulb toString: " + result);

        assertTrue(result.contains("Tulip"));
        assertTrue(result.contains("Pink"));
        assertTrue(result.contains("bulb=small"));
        assertTrue(result.contains("20.00"));
    }

    @Test
    void testTulipDifferentBulbTypes() {
        ColorTone yellowColor = new YellowTone();
        LocalDate harvestDate = LocalDate.now().minusDays(2);

        Tulip tulip1 = new Tulip(yellowColor, harvestDate, 35.0, new BigDecimal("25.00"), "large");
        Tulip tulip2 = new Tulip(yellowColor, harvestDate, 35.0, new BigDecimal("25.00"), "medium");
        Tulip tulip3 = new Tulip(yellowColor, harvestDate, 35.0, new BigDecimal("25.00"), "small");

        assertEquals("large", tulip1.getBulbType());
        assertEquals("medium", tulip2.getBulbType());
        assertEquals("small", tulip3.getBulbType());
    }
}