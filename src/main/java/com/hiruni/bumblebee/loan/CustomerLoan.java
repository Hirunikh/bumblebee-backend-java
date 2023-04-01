package com.hiruni.bumblebee.loan;

import com.hiruni.bumblebee.payment.Payment;
import com.hiruni.bumblebee.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class CustomerLoan {

    private Loan loanInfo;

    private Product product;
    private List<Payment> payments;

}
