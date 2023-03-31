package com.hiruni.bumblebee.loyalty;

import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity(name = "Loyalty")
public class Loyalty {
    @Id
    @SequenceGenerator(
            name = "Loyalty_Sequence",
            sequenceName = "Loyalty_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Loyalty_Sequence"
    )
    @Column(
            name = "LoyaltyID",
            updatable = false
    )
    private Integer loyaltyID;

    @Column(
            name = "CustomerID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer customerID;

    @Column(
            name = "LoyaltyPoints",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer loyaltyPoints;

    public Loyalty (Integer LoyaltyID,
                    Integer CustomerID,
                    Integer LoyaltyPoints)
    {
        this.loyaltyID = LoyaltyID;
        this.customerID = CustomerID;
        this.loyaltyPoints = LoyaltyPoints;
    }

    public Integer getLoyaltyID() {
        return loyaltyID;
    }

    public void setLoyaltyID(Integer loyaltyID) {
        this.loyaltyID = loyaltyID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Loyalty{" +
                "loyaltyID=" + loyaltyID +
                ", customerID=" + customerID +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
