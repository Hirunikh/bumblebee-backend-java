package com.hiruni.bumblebee.loan;

import com.hiruni.bumblebee.category.Category;
import com.hiruni.bumblebee.config.ApiError;
import com.hiruni.bumblebee.customers.Customers;
import com.hiruni.bumblebee.customers.CustomersRepository;
import com.hiruni.bumblebee.customers.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Loan")
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void addNewLoan(Loan newLoan) {
        newLoan.setInterestRate(0.0);
        loanRepository.save(newLoan);
    }

    public List<Loan> getLoan() {
        return loanRepository.findAll();
    }

    public void deleteLoan(Integer loanID) {
        boolean exists = loanRepository.existsById(loanID);
        if(!exists){
            throw new ApiError("Loan with this ID does not exist", HttpStatus.BAD_REQUEST);
        }
        loanRepository.deleteById(loanID);
    }

    public void updateLoan(Integer loanID,
                           String NewInstallmentPlan,
                           Double NewInterestRate,
                           Double NewLoanAmount,
                           Integer NewCustomerID,
                           Integer NewProductID)
    {
        Loan loan = loanRepository.findByLoanID(loanID)
                .orElseThrow( () -> new ApiError("This Category does not exist.", HttpStatus.BAD_REQUEST));
        if (NewInstallmentPlan != null && NewInstallmentPlan.length() > 0 && !NewInstallmentPlan.equals(loan.getInstallmentPlan())) {
            loan.setInstallmentPlan(NewInstallmentPlan);
        }
            if (NewInterestRate != null && NewInterestRate.doubleValue() > 0 && !NewInterestRate.equals(loan.getInterestRate())) {
                loan.setInterestRate(NewInterestRate);
            }
                if (NewLoanAmount != null && NewLoanAmount.doubleValue() > 0 && !NewLoanAmount.equals(loan.getLoanAmount())) {
                    loan.setLoanAmount(NewLoanAmount);
                }
                    if (NewCustomerID != null && NewCustomerID.intValue() > 0 && !NewCustomerID.equals(loan.getCustomerID())) {
                        loan.setCustomerID(NewCustomerID);
                    }
                        if (NewProductID != null && NewProductID.intValue() > 0 && !NewProductID.equals(loan.getCustomerID())) {
                            loan.setProductID(NewProductID);
                        }

            loanRepository.save(loan);

    }
}
