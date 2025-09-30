package flowershop.color;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColorToneTest {

    private static class TestColorTone extends ColorTone {
        public TestColorTone(String name) {
            super(name);
        }
    }

    @Test
    void testColorToneCreation() {

        String colorName = "TestColor";


        ColorTone color = new TestColorTone(colorName);


        assertEquals(colorName, color.getName());
    }

    @Test
    void testColorToneWithSimpleName() {
        String simpleName = "Red";

        ColorTone color = new TestColorTone(simpleName);

        assertEquals(simpleName, color.getName());
    }

    @Test
    void testColorToneWithComplexName() {
        String complexName = "Deep Sky Blue";

        ColorTone color = new TestColorTone(complexName);

        assertEquals(complexName, color.getName());
    }

    @Test
    void testColorToneWithEmptyName() {

        String emptyName = "";

        ColorTone color = new TestColorTone(emptyName);

        assertEquals(emptyName, color.getName());
    }

    @Test
    void testColorToneToString() {

        String colorName = "Magenta";
        ColorTone color = new TestColorTone(colorName);

        String result = color.toString();

        assertEquals(colorName, result);
        assertTrue(result.contains("Magenta"));
    }

    @Test
    void testColorToneToStringEqualsGetName() {

        String colorName = "Cyan";
        ColorTone color = new TestColorTone(colorName);


        assertEquals(color.getName(), color.toString());
    }

    @Test
    void testMultipleColorTones() {
        ColorTone color1 = new TestColorTone("Red");
        ColorTone color2 = new TestColorTone("Green");
        ColorTone color3 = new TestColorTone("Blue");

        assertEquals("Red", color1.getName());
        assertEquals("Green", color2.getName());
        assertEquals("Blue", color3.getName());
    }

    @Test
    void testColorToneImmutability() {

        String originalName = "OriginalColor";
        ColorTone color = new TestColorTone(originalName);

        assertEquals(originalName, color.getName());
        assertEquals(originalName, color.toString());
    }

    @Test
    void testColorToneCaseSensitivity() {
        ColorTone lowerCase = new TestColorTone("red");
        ColorTone upperCase = new TestColorTone("RED");
        ColorTone mixedCase = new TestColorTone("Red");

        assertEquals("red", lowerCase.getName());
        assertEquals("RED", upperCase.getName());
        assertEquals("Red", mixedCase.getName());

        assertNotEquals(lowerCase.getName(), upperCase.getName());
        assertNotEquals(lowerCase.getName(), mixedCase.getName());
    }
}