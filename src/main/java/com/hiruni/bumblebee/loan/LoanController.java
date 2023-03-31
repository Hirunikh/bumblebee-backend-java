package com.hiruni.bumblebee.loan;

import com.hiruni.bumblebee.customers.Customers;
import com.hiruni.bumblebee.customers.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Loan")
public class LoanController {

    private  final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<Loan> getLoan() {
        return loanService.getLoan();
    }

    @PostMapping
    public void CreateNewLoan(@RequestBody Loan loan) {
        loanService.addNewLoan(loan);
    }
}
