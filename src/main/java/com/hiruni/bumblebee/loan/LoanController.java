package com.hiruni.bumblebee.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @DeleteMapping(path = "{LoanID}")
    public void deleteLoan (
            @PathVariable ("LoanID") Integer loanID){
        loanService.deleteLoan(loanID);
    }

    @PutMapping(path = "{LoanID}")
    public void updateCategory(
            @PathVariable("LoanID") Integer loanID,
            @RequestParam String installmentPlan,
            @RequestParam (required = false) Double interestRate,
            @RequestParam Double loanAmount,
            //@RequestParam LocalDate paymentDueDate,
            @RequestParam (required = false) Integer customerID,
            @RequestParam (required = false) Integer productID){
        loanService.updateLoan(loanID,installmentPlan,interestRate,loanAmount,customerID,productID);
    }

    @GetMapping("/report/due-within")
    public LoanReportBetweenDays getLoansBetweenDays(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate fromDate,
                                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate toDate) {
        return loanService.getLoansBetweenDays(fromDate, toDate);
    }

}
