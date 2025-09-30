package flowershop.storage;

import flowershop.model.accessory.Accessory;
import flowershop.model.flower.Flower;
import flowershop.service.StorageService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SimpleFileStorage implements StorageService {
    @Override
    public void saveBouquet(List<Flower> flowers, List<Accessory> accessories, String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("# Flowers\n");
            for (Flower f : flowers) {
                writer.write(String.format("%s;%s;%.2f;%s;%s\n",
                        f.getName(), f.getColor().getName(), f.getStemLengthCm(), f.getPrice(), f.getHarvestDate()));
            }
            writer.write("# Accessories\n");
            for (Accessory a : accessories) {
                writer.write(String.format("%s;%s\n", a.getName(), a.getPrice()));
            }
        }
    }
}
