package com.hiruni.bumblebee.payment;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity(name = "Payment")
public class Payment {

    @Id
    @SequenceGenerator(
            name = "Payment_Sequence",
            sequenceName = "Payment_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Payment_Sequence"
    )
    @Column(
            name = "PaymentID",
            updatable = false
    )
    private Integer paymentID;

    @Column(
            name = "LoanID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer loanID;

    @Column(
            name = "OrderID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer orderID;

    @Column(
            name = "PaymentAmount",
            nullable = false
    )
    private  Float paymentAmount;

    @Column(
            name = "PaymentDate",
            nullable = false,
            columnDefinition = "Date"
    )
    private LocalDate paymentDate;

    @Column(
            name = "PaymentStatus",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String paymentStatus;

    public Payment (
            Integer PaymentID,
            Integer LoanID,
            Integer OrderID,
            Float PaymentAmount,
            LocalDate PaymentDate,
            String PaymentStatus)

    {
        this.paymentID = PaymentID;
        this.loanID = LoanID;
        this.orderID = OrderID;
        this.paymentAmount = PaymentAmount;
        paymentDate = PaymentDate;
        this.paymentStatus = PaymentStatus;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getLoanID() {
        return loanID;
    }

    public void setLoanID(Integer loanID) {
        this.loanID = loanID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        orderID = orderID;
    }

    public Float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", loanID=" + loanID +
                ", OrderID=" + orderID +
                ", paymentAmount=" + paymentAmount +
                ", paymentDate=" + paymentDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
