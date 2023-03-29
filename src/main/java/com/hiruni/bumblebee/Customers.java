package com.hiruni.bumblebee;

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
            name = "CustomerID",
            updatable = false
    )
    private Integer CustomerID;

    @Column(
            name = "CustomerName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String CustomerName;

    @Column(
            name = "DOB",
            nullable = false,
            columnDefinition = "DATE"
    )
    private Date DOB;

    @Column(
            name = "ContactNumber",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String ContactNumber;

    @Column(
            name = "Email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String Email;

    @Column(
            name = "Address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String Address;

    @Column(
            name = "LoanBalance",
            nullable = false
    )
    private Float LoanBalance;

    @Column(
            name = "UsedAmount",
            nullable = false
    )
    private Float UsedAmount;

    @Column(
            name = "InstallmentPlan",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String InstallmentPlan;

    public Customers (Integer customerID,
                     String customerName,
                     LocalDate DOB,
                     String contactNumber,
                     String email,
                     String address,
                     Float loanBalance,
                     Float usedAmount,
                     String installmentPlan)
    {
        CustomerID = customerID;
        CustomerName = customerName;
        DOB = DOB;
        ContactNumber = contactNumber;
        Email = email;
        Address = address;
        LoanBalance = loanBalance;
        UsedAmount = usedAmount;
        InstallmentPlan = installmentPlan;
    }

    public Integer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Integer customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Float getLoanBalance() {
        return LoanBalance;
    }

    public void setLoanBalance(Float loanBalance) {
        LoanBalance = loanBalance;
    }

    public Float getUsedAmount() {
        return UsedAmount;
    }

    public void setUsedAmount(Float usedAmount) {
        UsedAmount = usedAmount;
    }

    public String getInstallmentPlan() {
        return InstallmentPlan;
    }

    public void setInstallmentPlan(String installmentPlan) {
        InstallmentPlan = installmentPlan;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "CustomerID=" + CustomerID +
                ", CustomerName='" + CustomerName + '\'' +
                ", DOB=" + DOB +
                ", ContactNumber='" + ContactNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", LoanBalance=" + LoanBalance +
                ", UsedAmount=" + UsedAmount +
                ", InstallmentPlan='" + InstallmentPlan + '\'' +
                '}';
    }


}
