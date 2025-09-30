package flowershop.app;
import flowershop.accessory.Ribbon;
import flowershop.accessory.WrappingPaper;
import flowershop.color.*;
import flowershop.flower.Lily;
import flowershop.flower.Rose;
import flowershop.flower.Tulip;
import flowershop.service.BouquetService;
import flowershop.util.FileDataLoader;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private final BouquetService service = new BouquetService();
    private static final String DATA_FILE = "flower_data.txt";

    public static void main(String[] args) {
        new ConsoleApplication().run();
    }

    public void run() {
        seedFromFile();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1) Show bouquet  2) Price  3) Sort by freshness (asc) 4) Sort by freshness (desc)  5) Find by stem  0) Exit");
            System.out.print("Choice: ");
            String cmd = scanner.nextLine().trim();
            switch (cmd) {
                case "1" -> show();
                case "2" -> System.out.println("Total: " + service.calculateTotalPrice());
                case "3" -> {
                    service.sortByFreshnessAscending();
                    System.out.println("Sorted by freshness (ascending)");
                    show();
                }
                case "4" -> {
                    service.sortByFreshnessDescending();
                    System.out.println("Sorted by freshness (descending)");
                    show();
                }
                case "5" -> {
                    try {
                        System.out.print("min: "); double min = Double.parseDouble(scanner.nextLine());
                        System.out.print("max: "); double max = Double.parseDouble(scanner.nextLine());
                        List<?> found = service.findByStemRange(min, max);
                        found.forEach(System.out::println);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format");
                    }
                }
                case "0" -> { System.out.println("Bye"); return; }
                default -> System.out.println("Unknown");
            }
        }
    }

    private void seedFromFile() {
        List<String> lines = FileDataLoader.loadDataFromFile(DATA_FILE);

        if (lines.isEmpty()) {
            seedDefault();
            return;
        }

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }

            try {
                String[] parts = line.split(",");
                switch (parts[0]) {
                    case "Rose" -> {
                        int quantity = parts.length > 6 ? Integer.parseInt(parts[6]) : 1;
                        service.addFlower(createRose(parts), quantity);
                    }
                    case "Tulip" -> {
                        int quantity = parts.length > 6 ? Integer.parseInt(parts[6]) : 1;
                        service.addFlower(createTulip(parts), quantity);
                    }
                    case "Lily" -> {
                        int quantity = parts.length > 6 ? Integer.parseInt(parts[6]) : 1;
                        service.addFlower(createLily(parts), quantity);
                    }
                    case "Ribbon" -> service.addAccessory(createRibbon(parts));
                    case "WrappingPaper" -> service.addAccessory(createWrappingPaper(parts));
                    default -> System.out.println("Unknown type in file: " + parts[0]);
                }
            } catch (Exception e) {
                System.out.println("Error processing line: " + line + " - " + e.getMessage());
            }
        }
    }

    private Rose createRose(String[] parts) {
        return new Rose(
                createColor(parts[1]),
                LocalDate.now().minusDays(Integer.parseInt(parts[2])),
                Double.parseDouble(parts[3]),
                BigDecimal.valueOf(Double.parseDouble(parts[4])),
                Boolean.parseBoolean(parts[5])
        );
    }

    private Tulip createTulip(String[] parts) {
        return new Tulip(
                createColor(parts[1]),
                LocalDate.now().minusDays(Integer.parseInt(parts[2])),
                Double.parseDouble(parts[3]),
                BigDecimal.valueOf(Double.parseDouble(parts[4])),
                parts[5] // bulb_type
        );
    }

    private Lily createLily(String[] parts) {
        return new Lily(
                createColor(parts[1]),
                LocalDate.now().minusDays(Integer.parseInt(parts[2])),
                Double.parseDouble(parts[3]),
                BigDecimal.valueOf(Double.parseDouble(parts[4])),
                Integer.parseInt(parts[5]) // petal_count
        );
    }

    private Ribbon createRibbon(String[] parts) {
        return new Ribbon(
                parts[1], // material
                BigDecimal.valueOf(Double.parseDouble(parts[2])),
                Double.parseDouble(parts[3]) // length
        );
    }

    private WrappingPaper createWrappingPaper(String[] parts) {
        return new WrappingPaper(
                parts[1], // material
                BigDecimal.valueOf(Double.parseDouble(parts[2])),
                parts[3] // pattern
        );
    }

    private ColorTone createColor(String colorName) {
        return switch (colorName.toLowerCase()) {
            case "red" -> new RedTone();
            case "yellow" -> new YellowTone();
            case "pink" -> new PinkTone();
            default -> new RedTone();
        };
    }

    private void seedDefault() {
        System.out.println("Using default data...");
        service.addFlower(new Rose(new RedTone(), LocalDate.now().minusDays(1), 50.0, BigDecimal.valueOf(40), true), 3);
        service.addFlower(new Tulip(new YellowTone(), LocalDate.now().minusDays(3), 35.0, BigDecimal.valueOf(30), "large"), 3);
        service.addFlower(new Lily(new PinkTone(), LocalDate.now().minusDays(2), 60.0, BigDecimal.valueOf(90), 6), 3);
        service.addAccessory(new Ribbon("satin", BigDecimal.valueOf(15.0), 2.5));
        service.addAccessory(new WrappingPaper("cellophane", BigDecimal.valueOf(10.0), "floral"));
    }

    private void show() {
        System.out.println("\n=== BOUQUET ===");
        System.out.println("Flowers:");
        service.getFlowers().forEach(f -> System.out.println("  " + f));
        System.out.println("Accessories:");
        service.getAccessories().forEach(a -> System.out.println("  " + a));
        System.out.println("Total price: " + service.calculateTotalPrice());
    }
}