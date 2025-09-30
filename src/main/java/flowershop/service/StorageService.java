package flowershop.service;

import flowershop.model.accessory.Accessory;
import flowershop.model.flower.Flower;
import java.io.IOException;
import java.util.List;

public interface StorageService {
    void saveBouquet(List<Flower> flowers, List<Accessory> accessories, String path) throws IOException;
}
