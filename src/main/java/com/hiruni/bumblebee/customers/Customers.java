package com.hiruni.bumblebee.customers;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity (name = "Customers")
@Table (
        name = "customers",
        uniqueConstraints = {
                @UniqueConstraint(name = "customers_Email_unique", columnNames = "Email")
        }
)
public class Customers {

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
            name = "customerID",
            updatable = false
    )
    private Integer customerID;

    @Column(
            name = "customerName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String customerName;

    @Column(
            name = "dob",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate dob;

    @Column(
            name = "contactNumber",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String contactNumber;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;

    @Column(
            name = "loanBalance",
            nullable = false
    )
    private Double loanBalance;

    @Column(
            name = "usedAmount",
            nullable = false
    )
    private Double usedAmount;

    @Column(
            name = "creditLimit",
            nullable = false
    )
    private Double creditLimit;

    @Column(
            name = "installmentPlan",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String installmentPlan;

    public Customers (Integer customerID,
                     String customerName,
                     LocalDate DOB,
                     String contactNumber,
                     String email,
                     String address,
                     Double loanBalance,
                     Double usedAmount, Double creditLimit,
                     String installmentPlan)
    {
        this.customerID = customerID;
        this.customerName = customerName;
        this.dob = DOB;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.loanBalance = loanBalance;
        this.usedAmount = usedAmount;
        this.installmentPlan = installmentPlan;
        this.creditLimit = creditLimit;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Double loanBalance) {
        this.loanBalance = loanBalance;
    }

    public Double getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Double usedAmount) {
        this.usedAmount = usedAmount;
    }

    public String getInstallmentPlan() {
        return installmentPlan;
    }

    public void setInstallmentPlan(String installmentPlan) {
        this.installmentPlan = installmentPlan;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "CustomerID=" + customerID +
                ", CustomerName='" + customerName + '\'' +
                ", DOB=" + dob +
                ", ContactNumber='" + contactNumber + '\'' +
                ", Email='" + email + '\'' +
                ", Address='" + address + '\'' +
                ", LoanBalance=" + loanBalance +
                ", UsedAmount=" + usedAmount +
                ", InstallmentPlan='" + installmentPlan + '\'' +
                '}';
    }


}
