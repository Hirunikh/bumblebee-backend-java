package com.hiruni.bumblebee.loan;

import com.hiruni.bumblebee.customers.Customer;
import com.hiruni.bumblebee.payment.Payment;
import com.hiruni.bumblebee.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class LoanReport {

    private Loan loanInfo;
    private Customer customerInfo;

    private Product product;
    private List<Payment> payments;
}
