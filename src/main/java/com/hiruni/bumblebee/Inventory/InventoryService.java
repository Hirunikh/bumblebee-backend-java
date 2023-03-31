package com.hiruni.bumblebee.Inventory;

import com.hiruni.bumblebee.Category.Category;
import com.hiruni.bumblebee.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void addNewInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }


    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

}