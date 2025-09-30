package flowershop.service;

import flowershop.accessory.Ribbon;
import flowershop.accessory.WrappingPaper;
import flowershop.color.RedTone;
import flowershop.color.YellowTone;
import flowershop.flower.Flower;
import flowershop.flower.Rose;
import flowershop.flower.Tulip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BouquetServiceIntegrationTest {

    private BouquetService bouquetService;
    private Rose rose;
    private Tulip tulip;
    private Ribbon ribbon;
    private WrappingPaper wrappingPaper;

    @BeforeEach
    void setUp() {
        bouquetService = new BouquetService();

        rose = new Rose(
                new RedTone(),
                LocalDate.now().minusDays(1),
                50.0,
                new BigDecimal("40.00"),
                true
        );

        tulip = new Tulip(
                new YellowTone(),
                LocalDate.now().minusDays(3),
                35.0,
                new BigDecimal("30.00"),
                "large"
        );

        ribbon = new Ribbon("satin", new BigDecimal("15.00"), 2.5);
        wrappingPaper = new WrappingPaper("cellophane", new BigDecimal("10.00"), "floral");
    }

    @Test
    void testIntegrationCalculateTotalPrice() {

        bouquetService.addFlower(rose, 2);
        bouquetService.addFlower(tulip, 1);
        bouquetService.addAccessory(ribbon);
        bouquetService.addAccessory(wrappingPaper);

        BigDecimal total = bouquetService.calculateTotalPrice();

        assertEquals(new BigDecimal("135.00"), total);
    }

    @Test
    void testIntegrationSortByFreshness() {
        bouquetService.addFlower(tulip, 1);
        bouquetService.addFlower(rose, 1);

        bouquetService.sortByFreshnessAscending();

        List<Flower> flowers = bouquetService.getFlowers();
        assertEquals(rose, flowers.get(0));
        assertEquals(tulip, flowers.get(1));
    }

    @Test
    void testIntegrationFindByStemRange() {
        bouquetService.addFlower(rose, 2);
        bouquetService.addFlower(tulip, 1);

        List<Flower> found = bouquetService.findByStemRange(40.0, 60.0);

        assertEquals(2, found.size());
        assertTrue(found.stream().allMatch(f -> f instanceof Rose));
    }
}