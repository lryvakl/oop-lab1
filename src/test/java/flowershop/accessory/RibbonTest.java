package flowershop.accessory;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class RibbonTest {

    @Test
    void testRibbonCreation() {
        String material = "satin";
        BigDecimal price = new BigDecimal("15.00");
        double length = 2.5;

        Ribbon ribbon = new Ribbon(material, price, length);

        assertEquals("Ribbon", ribbon.getName());
        assertEquals(material, ribbon.getMaterial());
        assertEquals(price, ribbon.getPrice());
        assertEquals(length, ribbon.getLength(), 0.001);
    }

    @Test
    void testRibbonDefaultConstructor() {
        Ribbon ribbon = new Ribbon();

        assertEquals("Ribbon", ribbon.getName());
        assertEquals("satin", ribbon.getMaterial());
        assertEquals(new BigDecimal("15.0"), ribbon.getPrice());
        assertEquals(2.5, ribbon.getLength(), 0.001);
    }


    @Test
    void testRibbonWithDifferentMaterials() {
        Ribbon satinRibbon = new Ribbon("satin", new BigDecimal("15.00"), 2.5);
        Ribbon silkRibbon = new Ribbon("silk", new BigDecimal("25.00"), 3.0);
        Ribbon laceRibbon = new Ribbon("lace", new BigDecimal("18.50"), 1.5);

        assertEquals("satin", satinRibbon.getMaterial());
        assertEquals("silk", silkRibbon.getMaterial());
        assertEquals("lace", laceRibbon.getMaterial());
    }

    @Test
    void testRibbonWithDifferentLengths() {
        Ribbon shortRibbon = new Ribbon("satin", new BigDecimal("10.00"), 1.0);
        Ribbon mediumRibbon = new Ribbon("satin", new BigDecimal("15.00"), 2.5);
        Ribbon longRibbon = new Ribbon("satin", new BigDecimal("20.00"), 5.0);

        assertEquals(1.0, shortRibbon.getLength(), 0.001);
        assertEquals(2.5, mediumRibbon.getLength(), 0.001);
        assertEquals(5.0, longRibbon.getLength(), 0.001);
    }
}