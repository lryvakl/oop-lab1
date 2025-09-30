package flowershop.util;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileDataLoaderTest {

    @Test
    void testLoadDataFromExistingFile() {
        String testFile = "flower_data.txt";

        List<String> lines = FileDataLoader.loadDataFromFile(testFile);

        assertFalse(lines.isEmpty());
        assertTrue(lines.stream().anyMatch(line -> !line.trim().isEmpty() && !line.startsWith("#")));
    }

    @Test
    void testLoadDataFromNonExistingFile() {
        String nonExistingFile = "non_existing_file.txt";

        List<String> lines = FileDataLoader.loadDataFromFile(nonExistingFile);

        assertTrue(lines.isEmpty());
    }

    @Test
    void testLoadDataWithCommentsAndEmptyLines() {
        assertDoesNotThrow(() -> {
            List<String> lines = FileDataLoader.loadDataFromFile("flower_data.txt");
        });
    }
}