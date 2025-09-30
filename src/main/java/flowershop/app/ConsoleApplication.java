package flowershop.app;
import flowershop.accessory.Ribbon;
import flowershop.accessory.WrappingPaper;
import flowershop.color.PinkTone;
import flowershop.color.RedTone;
import flowershop.color.YellowTone;
import flowershop.flower.Lily;
import flowershop.flower.Rose;
import flowershop.flower.Tulip;
import flowershop.service.BouquetService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private final BouquetService service = new BouquetService();
    public static void main(String[] args) {
        new ConsoleApplication().run();
    }

    public void run() {
        seed();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1) Show bouquet  2) Price  3) Sort by freshness (asc) 4) Sort by freshness (desc)  5) Find by stem  0) Exit");
            System.out.print("Choice: ");
            String cmd = scanner.nextLine().trim();
            switch (cmd) {
                case "1" -> show();
                case "2" -> System.out.println("Total: " + service.calculateTotalPrice());
                case "3" -> { service.sortByFreshnessAscending(); show(); }
                case "4" -> { service.sortByFreshnessDescending(); show(); }
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

    private void seed() {
        service.addFlower(new Rose(new RedTone(), LocalDate.now().minusDays(1), 50.0, BigDecimal.valueOf(40), true), 3);
        service.addFlower(new Tulip(new YellowTone(), LocalDate.now().minusDays(3), 35.0, BigDecimal.valueOf(30), "large"), 3);
        service.addFlower(new Lily(new PinkTone(), LocalDate.now().minusDays(2), 60.0, BigDecimal.valueOf(90), 6), 3);
        service.addAccessory(new Ribbon("satin", BigDecimal.valueOf(15.0), 2.5));
        service.addAccessory(new WrappingPaper("cellophane", BigDecimal.valueOf(10.0), "floral"));
    }

    private void show() {
        service.getFlowers().forEach(System.out::println);
        service.getAccessories().forEach(System.out::println);
    }
}
