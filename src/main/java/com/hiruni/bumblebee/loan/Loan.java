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
    private float loanAmount;

    @Column(
            name = "InterestRate",
            nullable = false
    )
    private  float interestRate;

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

    public Loan (Integer LoanID,
                Float LoanAmount,
                Float InterestRate,
                String InstallmentPlan,
                LocalDate PaymentDueDate,
                 Integer customerID )
    {
        this.loanID = LoanID;
        this.loanAmount = LoanAmount;
        this.interestRate = InterestRate;
        this.installmentPlan = InstallmentPlan;
        this.paymentDueDate = PaymentDueDate;
        this.customerID = customerID;

    }

    public Integer getLoanID() {
        return loanID;
    }

    public void setLoanID(Integer loanID) {
        this.loanID = loanID;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
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

    @Override
    public String toString() {
        return "Loan{" +
                "loanID=" + loanID +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", installmentPlan='" + installmentPlan + '\'' +
                ", paymentDueDate=" + paymentDueDate +
                "customerID=" + customerID +
                '}';
    }
}
