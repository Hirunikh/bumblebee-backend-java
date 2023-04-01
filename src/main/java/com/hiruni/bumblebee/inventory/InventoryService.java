package com.hiruni.bumblebee.inventory;

import com.hiruni.bumblebee.category.Category;
import com.hiruni.bumblebee.config.ApiError;
import com.hiruni.bumblebee.product.Product;
import com.hiruni.bumblebee.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }

    public void addNewInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }


    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

    public void deleteInventory(Integer inventoryID) {
        boolean exists = inventoryRepository.existsById(inventoryID);
        if(!exists){
            throw new ApiError("Inventory with this ID does not exist", HttpStatus.BAD_REQUEST);
        }
        inventoryRepository.deleteById(inventoryID);
    }
    @Transactional
    public void updateInventory(Integer inventoryID, Integer productID, Integer newStockQuantity, String newStockLocation) {
        Inventory inventory = inventoryRepository.findByInventoryID(inventoryID)
                .orElseThrow( () -> new ApiError("This Inventory does not exist.", HttpStatus.BAD_REQUEST));
        Product product = productRepository.findByProductID(productID)
                .orElseThrow( () -> new ApiError("Product does not exist.", HttpStatus.BAD_REQUEST));
        if (newStockQuantity != null && newStockQuantity > 0 && !newStockQuantity.equals(inventory.getStockQuantity()))
            inventory.setStockQuantity(newStockQuantity);
        if (newStockLocation != null && newStockLocation.length() > 0 && !newStockLocation.equals(inventory.getStockLocation())){
            inventory.setStockLocation(newStockLocation);
        }
        inventoryRepository.save(inventory);
    }
}
