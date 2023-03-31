package com.hiruni.bumblebee.Inventory;

import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity(name = "Inventory")
public class Inventory {

    @Id
    @SequenceGenerator(
            name = "Inventory_Sequence",
            sequenceName = "inventory_Sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Inventory_Sequence"
    )

    @Column(
            name = "InventoryID",
            updatable = false
    )
    private Integer inventoryID;

    @Column(
            name = "ProductID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer productID;

    @Column(
            name = "StockQuantity",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer stockQuantity;

    @Column(
            name = "StockLocation",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String stockLocation;

    public Inventory (
            Integer InventoryID,
            Integer ProductID,
            Integer StockQuantity,
            String StockLocation
    )
    {
        this.inventoryID = InventoryID;
        this.productID = ProductID;
        this.stockQuantity = StockQuantity;
        this.stockLocation = StockLocation;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public String getStockLocation() {
        return stockLocation;
    }

    public void setStockLocation(String stockLocation) {
        this.stockLocation = stockLocation;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "InventoryID=" + inventoryID +
                "ProductID=" + productID +
                "StockQuantity=" + stockQuantity +
                ", StockLocation='" + stockLocation + '\'' +
                '}';
    }
}
