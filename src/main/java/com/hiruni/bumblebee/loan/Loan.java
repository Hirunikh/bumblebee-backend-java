package com.hiruni.bumblebee.loan;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity(name = "Loan")
public class Loan {

    @Id
    @SequenceGenerator(
            name = "Loan_Sequence",
            sequenceName = "Loan_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Loan_Sequence"
    )

    @Column(
            name = "LoanID",
            updatable = false
    )
    private Integer loanID;

    @Column(
            name = "LoanAmount",
            nullable = false
    )
    private double loanAmount;

    @Column(
            name = "InterestRate",
            nullable = false
    )
    private  double interestRate;

    @Column(
            name = "InstallmentPlan",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String installmentPlan;

    @Column(
            name = "PaymentDueDate",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate paymentDueDate;

    @Column(
            name = "customerID",
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

    public Loan (Integer LoanID,
                Double LoanAmount,
                Double InterestRate,
                 String InstallmentPlan,
                LocalDate PaymentDueDate,
                 Integer customerID,
                 Integer ProductID)
    {
        this.loanID = LoanID;
        this.loanAmount = LoanAmount;
        this.interestRate = InterestRate;
        this.installmentPlan = InstallmentPlan;
        this.paymentDueDate = PaymentDueDate;
        this.customerID = customerID;
        this.productID = ProductID;

    }

    public Integer getLoanID() {
        return loanID;
    }

    public void setLoanID(Integer loanID) {
        this.loanID = loanID;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getInstallmentPlan() {
        return installmentPlan;
    }

    public void setInstallmentPlan(String installmentPlan) {
        this.installmentPlan = installmentPlan;
    }

    public LocalDate getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(LocalDate paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
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

    @Override
    public String toString() {
        return "Loan{" +
                "loanID=" + loanID +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", installmentPlan='" + installmentPlan + '\'' +
                ", paymentDueDate=" + paymentDueDate +
                ", customerID=" + customerID +
                ", productID=" + productID +
                '}';
    }
}
