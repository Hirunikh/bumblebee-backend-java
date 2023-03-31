package com.hiruni.bumblebee.loan;

import com.hiruni.bumblebee.customers.Customers;
import com.hiruni.bumblebee.customers.CustomersRepository;
import com.hiruni.bumblebee.customers.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Loan")
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void addNewLoan(Loan loan) {
        loanRepository.save(loan);
    }

    public List<Loan> getLoan() {
        return loanRepository.findAll();
    }
}
