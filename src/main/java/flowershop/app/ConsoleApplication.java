package flowershop.app;
import flowershop.model.accessory.Ribbon;
import flowershop.model.accessory.WrappingPaper;
import flowershop.model.color.PinkTone;
import flowershop.model.color.RedTone;
import flowershop.model.color.YellowTone;
import flowershop.model.flower.Lily;
import flowershop.model.flower.Rose;
import flowershop.model.flower.Tulip;
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
            System.out.println("\n1) Show bouquet  2) Price  3) Sort by freshness  4) Find by stem  0) Exit");
            System.out.print("Choice: ");
            String cmd = scanner.nextLine().trim();
            switch (cmd) {
                case "1" -> show();
                case "2" -> System.out.println("Total: " + service.calculateTotalPrice());
                case "3" -> { service.sortByFreshnessAscending(); show(); }
                case "4" -> {
                    System.out.print("min: "); double min = Double.parseDouble(scanner.nextLine());
                    System.out.print("max: "); double max = Double.parseDouble(scanner.nextLine());
                    List<?> found = service.findByStemRange(min, max);
                    found.forEach(System.out::println);
                }
                case "0" -> { System.out.println("Bye"); return; }
                default -> System.out.println("Unknown");
            }
        }
    }

    private void seed() {
        service.addFlower(new Rose(new RedTone(), LocalDate.now().minusDays(1), 50.0, BigDecimal.valueOf(40)),3);
        service.addFlower(new Tulip(new YellowTone(), LocalDate.now().minusDays(3), 35.0, BigDecimal.valueOf(30)),3);
        service.addFlower(new Lily(new PinkTone(), LocalDate.now().minusDays(2), 60.0, BigDecimal.valueOf(90)),3);
        service.addAccessory(new Ribbon());
        service.addAccessory(new WrappingPaper());
    }

    private void show() {
        service.getFlowers().forEach(System.out::println);
        service.getAccessories().forEach(System.out::println);
    }
}
