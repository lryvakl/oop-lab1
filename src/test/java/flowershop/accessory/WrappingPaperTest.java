package flowershop.accessory;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class WrappingPaperTest {

    @Test
    void testWrappingPaperCreation() {
        String material = "cellophane";
        BigDecimal price = new BigDecimal("10.0");
        String pattern = "floral";

        WrappingPaper paper = new WrappingPaper(material, price, pattern);

        assertEquals("Wrapping Paper", paper.getName());
        assertEquals(material, paper.getMaterial());
        assertEquals(price, paper.getPrice());
        assertEquals(pattern, paper.getPattern());
    }

    @Test
    void testWrappingPaperDefaultConstructor() {
        WrappingPaper paper = new WrappingPaper();

        assertEquals("Wrapping Paper", paper.getName());
        assertEquals("cellophane", paper.getMaterial());
        assertEquals(new BigDecimal("10.0"), paper.getPrice());
        assertEquals("floral", paper.getPattern());
    }

    @Test
    void testWrappingPaperToString() {

        WrappingPaper paper = new WrappingPaper("kraft", new BigDecimal("12.50"), "striped");
        String result = paper.toString();

        assertTrue(result.contains("Wrapping Paper"));
        assertTrue(result.contains("12.50"));
        assertTrue(result.contains("kraft"));
        assertTrue(result.contains("striped"));
    }

    @Test
    void testWrappingPaperWithDifferentPatterns() {
        WrappingPaper floral = new WrappingPaper("cellophane", new BigDecimal("10.00"), "floral");
        WrappingPaper striped = new WrappingPaper("cellophane", new BigDecimal("10.00"), "striped");
        WrappingPaper polkaDot = new WrappingPaper("cellophane", new BigDecimal("10.00"), "polka dot");

        assertEquals("floral", floral.getPattern());
        assertEquals("striped", striped.getPattern());
        assertEquals("polka dot", polkaDot.getPattern());
    }

    @Test
    void testWrappingPaperWithDifferentMaterials() {

        WrappingPaper cellophane = new WrappingPaper("cellophane", new BigDecimal("8.00"), "floral");
        WrappingPaper kraft = new WrappingPaper("kraft", new BigDecimal("12.00"), "floral");
        WrappingPaper glossy = new WrappingPaper("glossy", new BigDecimal("15.00"), "floral");

        assertEquals("cellophane", cellophane.getMaterial());
        assertEquals("kraft", kraft.getMaterial());
        assertEquals("glossy", glossy.getMaterial());
    }
}