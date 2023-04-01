package com.hiruni.bumblebee.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Inventory")
public class InventoryController {

    private  final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> getInventory() {
        return inventoryService.getInventory();
    }

    @PostMapping
    public void CreateNewInventory(@RequestBody Inventory inventory) {
        inventoryService.addNewInventory(inventory);
    }

    @DeleteMapping(path = "{InventoryID}")
    public void deleteInventory(
            @PathVariable ("InventoryID") Integer inventoryID){
        inventoryService.deleteInventory(inventoryID);
    }

    @PutMapping(path = "{InventoryID}")
    public void updateInventory(
            @PathVariable("InventoryID") Integer inventoryID,
            @RequestParam Integer productID,
            @RequestParam Integer stockQuantity,
            @RequestParam String stockLocation){
        inventoryService.updateInventory(inventoryID,productID,stockQuantity,stockLocation);
    }

}
