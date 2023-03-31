package com.hiruni.bumblebee.order;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity(name = "Order")
public class Order {

    @Id
    @SequenceGenerator(
            name = "Order_Sequence",
            sequenceName = "Order_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Order_Sequence"
    )

    @Column(
            name = "OrderID",
            updatable = false
    )
    private Integer orderID;

    @Column(
            name = "OrderDate",
            nullable = false,
            columnDefinition = "Date"
    )
    private LocalDate orderDate;

    @Column(
            name = "CustomerID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer customerID;

    @Column(
            name = "ProductID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer productID;

    @Column(
            name = "Quantity",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer quantity;

    @Column(
            name = "TotalCost",
            nullable = false
    )
    private  Float totalCost;

    public Order (
            Integer OrderID,
            LocalDate OrderDate,
            Integer CustomerID,
            Integer ProductID,
            Integer Quantity,
            Float TotalCost)

    {
        this.orderID = OrderID;
        orderDate = OrderDate;
        this.customerID = CustomerID;
        this.productID = ProductID;
        this.quantity = Quantity;
        this.totalCost = TotalCost;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", customerID=" + customerID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", totalCost=" + totalCost +
                '}';
    }
}
