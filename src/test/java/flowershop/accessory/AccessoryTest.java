package flowershop.accessory;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class AccessoryTest {


    private static class TestAccessory extends Accessory {
        public TestAccessory(String name, BigDecimal price) {
            super(name, price);
        }
    }

    @Test
    void testAccessoryCreation() {

        String name = "Test Accessory";
        BigDecimal price = new BigDecimal("25.50");

        Accessory accessory = new TestAccessory(name, price);

        assertEquals(name, accessory.getName());
        assertEquals(price, accessory.getPrice());
    }

    @Test
    void testAccessoryWithZeroPrice() {

        String name = "Free Accessory";
        BigDecimal zeroPrice = BigDecimal.ZERO;

        Accessory accessory = new TestAccessory(name, zeroPrice);

        assertEquals(name, accessory.getName());
        assertEquals(zeroPrice, accessory.getPrice());
    }

    @Test
    void testAccessoryWithHighPrice() {
        String name = "Luxury Accessory";
        BigDecimal highPrice = new BigDecimal("999.99");

        Accessory accessory = new TestAccessory(name, highPrice);

        assertEquals(name, accessory.getName());
        assertEquals(highPrice, accessory.getPrice());
    }

    @Test
    void testAccessoryToString() {

        String name = "Test Item";
        BigDecimal price = new BigDecimal("15.75");
        Accessory accessory = new TestAccessory(name, price);

        String result = accessory.toString();
        assertTrue(result.contains(name));
        assertTrue(result.contains("15.75"));
        assertEquals("Test Item (15.75)", result);
    }

    @Test
    void testAccessoryToStringWithDifferentFormats() {

        Accessory accessory1 = new TestAccessory("Item1", new BigDecimal("10"));
        Accessory accessory2 = new TestAccessory("Item2", new BigDecimal("20.00"));
        Accessory accessory3 = new TestAccessory("Item3", new BigDecimal("30.50"));

        assertEquals("Item1 (10)", accessory1.toString());
        assertEquals("Item2 (20.00)", accessory2.toString());
        assertEquals("Item3 (30.50)", accessory3.toString());
    }

    @Test
    void testAccessoryNameCannotBeNull() {
        String name = null;
        BigDecimal price = new BigDecimal("10.00");

        assertDoesNotThrow(() -> {
            Accessory accessory = new TestAccessory(name, price);
            assertNull(accessory.getName());
        });
    }

    @Test
    void testAccessoryImmutability() {

        String originalName = "Original Name";
        BigDecimal originalPrice = new BigDecimal("100.00");
        Accessory accessory = new TestAccessory(originalName, originalPrice);


        assertEquals(originalName, accessory.getName());
        assertEquals(originalPrice, accessory.getPrice());

        BigDecimal returnedPrice = accessory.getPrice();
        assertSame(originalPrice, returnedPrice);
    }

    @Test
    void testMultipleAccessoryInstances() {

        Accessory accessory1 = new TestAccessory("Item1", new BigDecimal("10.00"));
        Accessory accessory2 = new TestAccessory("Item2", new BigDecimal("20.00"));
        Accessory accessory3 = new TestAccessory("Item1", new BigDecimal("10.00"));


        assertEquals("Item1", accessory1.getName());
        assertEquals("Item2", accessory2.getName());
        assertEquals("Item1", accessory3.getName());

        assertEquals(new BigDecimal("10.00"), accessory1.getPrice());
        assertEquals(new BigDecimal("20.00"), accessory2.getPrice());
        assertEquals(new BigDecimal("10.00"), accessory3.getPrice());


        assertNotSame(accessory1, accessory2);
        assertNotSame(accessory1, accessory3);
    }
}