package flowershop.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileDataLoader {

    public static List<String> loadDataFromFile(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            Path filePath = Paths.get(filename);
            if (Files.exists(filePath)) {
                lines = Files.readAllLines(filePath);
                System.out.println("Loaded data from: " + filename);
            } else {
                System.out.println("File not found: " + filename + ". Using default data.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + ". Using default data.");
        }
        return lines;
    }
}