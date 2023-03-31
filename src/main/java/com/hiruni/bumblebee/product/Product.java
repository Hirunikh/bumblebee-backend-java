package com.hiruni.bumblebee.product;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity(name = "Product")
public class Product {

    @Id
    @SequenceGenerator(
            name = "Customers_Sequence",
            sequenceName = "Customers_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Customers_Sequence"
    )

    @Column(
            name = "ProductID",
            updatable = false
    )
    private Integer productID;

    @Column(
            name = "ProductName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String productName;

    @Column(
            name = "ProductDescription",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String productDescription;

    @Column(
            name = "CategoryID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer categoryID;

    @Column(
            name = "BrandID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer brandID;

    @Column(
            name = "Price",
            nullable = false
    )
    private Float price;

    @Column(
            name = "Quantity",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer quantity;

    public Product(Integer productID,
                   String productName,
                   String productDescription,
                   Integer categoryID,
                   Integer brandID,
                   Float price,
                   Integer quantity)
    {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.categoryID = categoryID;
        this.brandID = brandID;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", categoryID=" + categoryID +
                ", brandID=" + brandID +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
