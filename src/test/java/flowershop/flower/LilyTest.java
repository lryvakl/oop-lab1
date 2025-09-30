package flowershop.flower;

import flowershop.color.PinkTone;
import flowershop.color.PinkTone;
import flowershop.color.ColorTone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LilyTest {

    private Lily lilySixPetals;
    private Lily lilyEightPetals;

    @BeforeEach
    void setUp() {
        LocalDate harvestDate = LocalDate.now().minusDays(2);
        ColorTone pinkColor = new PinkTone();
        ColorTone whiteColor = new PinkTone();

        lilySixPetals = new Lily(pinkColor, harvestDate, 60.0, new BigDecimal("55.00"), 6);
        lilyEightPetals = new Lily(whiteColor, harvestDate.minusDays(1), 65.0, new BigDecimal("60.00"), 8);
    }

    @Test
    void testLilyCreationWithSixPetals() {
        assertEquals("Lily", lilySixPetals.getName());
        assertTrue(lilySixPetals.getColor() instanceof PinkTone);
        assertEquals(60.0, lilySixPetals.getStemLengthCm(), 0.001);
        assertEquals(new BigDecimal("55.00"), lilySixPetals.getPrice());
        assertEquals(6, lilySixPetals.getPetalCount());
    }

    @Test
    void testLilyCreationWithEightPetals() {
        assertEquals("Lily", lilyEightPetals.getName());
        assertTrue(lilyEightPetals.getColor() instanceof PinkTone);
        assertEquals(65.0, lilyEightPetals.getStemLengthCm(), 0.001);
        assertEquals(new BigDecimal("60.00"), lilyEightPetals.getPrice());
        assertEquals(8, lilyEightPetals.getPetalCount());
    }

    @Test
    void testLilyCopy() {
        Lily copy = (Lily) lilySixPetals.copy();

        assertEquals(lilySixPetals.getName(), copy.getName());
        assertEquals(lilySixPetals.getColor(), copy.getColor());
        assertEquals(lilySixPetals.getHarvestDate(), copy.getHarvestDate());
        assertEquals(lilySixPetals.getStemLengthCm(), copy.getStemLengthCm(), 0.001);
        assertEquals(lilySixPetals.getPrice(), copy.getPrice());
        assertEquals(lilySixPetals.getPetalCount(), copy.getPetalCount());

        assertNotSame(lilySixPetals, copy);
    }

    @Test
    void testLilyFreshnessDays() {
        LocalDate harvestDate = LocalDate.now().minusDays(5);
        ColorTone pinkColor = new PinkTone();
        Lily lily = new Lily(pinkColor, harvestDate, 60.0, new BigDecimal("55.00"), 6);

        assertEquals(5, lily.freshnessDays());
    }

    @Test
    void testLilyToStringWithSixPetals() {
        String result = lilySixPetals.toString();
        System.out.println("Lily with 6 petals toString: " + result);

        assertTrue(result.contains("Lily"));
        assertTrue(result.contains("Pink"));
        assertTrue(result.contains("petals=6"));
        assertTrue(result.contains("55.00"));
    }

    @Test
    void testLilyToStringWithEightPetals() {
        String result = lilyEightPetals.toString();
        System.out.println("Lily with 8 petals toString: " + result);

        assertTrue(result.contains("Lily"));
        assertTrue(result.contains("Pink"));
        assertTrue(result.contains("petals=8"));
        assertTrue(result.contains("60.00"));
    }

    @Test
    void testLilyDifferentPetalCounts() {
        ColorTone pinkColor = new PinkTone();
        LocalDate harvestDate = LocalDate.now().minusDays(2);

        Lily lily4 = new Lily(pinkColor, harvestDate, 55.0, new BigDecimal("50.00"), 4);
        Lily lily6 = new Lily(pinkColor, harvestDate, 60.0, new BigDecimal("55.00"), 6);
        Lily lily8 = new Lily(pinkColor, harvestDate, 65.0, new BigDecimal("60.00"), 8);

        assertEquals(4, lily4.getPetalCount());
        assertEquals(6, lily6.getPetalCount());
        assertEquals(8, lily8.getPetalCount());
    }

    @Test
    void testLilyEdgeCasePetalCount() {
        ColorTone pinkColor = new PinkTone();
        LocalDate harvestDate = LocalDate.now().minusDays(1);

        Lily lilyMin = new Lily(pinkColor, harvestDate, 50.0, new BigDecimal("45.00"), 1);
        Lily lilyMax = new Lily(pinkColor, harvestDate, 70.0, new BigDecimal("75.00"), 12);

        assertEquals(1, lilyMin.getPetalCount());
        assertEquals(12, lilyMax.getPetalCount());
    }
}