package com.hiruni.bumblebee.loan;

import com.hiruni.bumblebee.config.ApiError;
import com.hiruni.bumblebee.customers.Customer;
import com.hiruni.bumblebee.customers.CustomersRepository;
import com.hiruni.bumblebee.payment.Payment;
import com.hiruni.bumblebee.payment.PaymentRepository;
import com.hiruni.bumblebee.product.Product;
import com.hiruni.bumblebee.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Loan")
public class LoanService {
    private final LoanRepository loanRepository;
    private final CustomersRepository customersRepository;
    private final ProductRepository productRepository;

    private final PaymentRepository paymentRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository, CustomersRepository customersRepository,
                       ProductRepository productRepository, PaymentRepository paymentRepository) {
        this.loanRepository = loanRepository;
        this.productRepository = productRepository;
        this.customersRepository = customersRepository;
        this.paymentRepository = paymentRepository;
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
            if (NewInterestRate != null && NewInterestRate > 0 && !NewInterestRate.equals(loan.getInterestRate())) {
                loan.setInterestRate(NewInterestRate);
            }
            if (NewLoanAmount != null && NewLoanAmount > 0 && !NewLoanAmount.equals(loan.getLoanAmount())) {
                loan.setLoanAmount(NewLoanAmount);
            }
            if (NewCustomerID != null && NewCustomerID > 0 && !NewCustomerID.equals(loan.getCustomerID())) {
                loan.setCustomerID(NewCustomerID);
            }
            if (NewProductID != null && NewProductID > 0 && !NewProductID.equals(loan.getCustomerID())) {
                loan.setProductID(NewProductID);
            }

            loanRepository.save(loan);

    }

    public LoanReportBetweenDays getLoansBetweenDays(LocalDate fromDate, LocalDate toDate) {

        List<Loan> loans = loanRepository.findByPaymentDueDateBetween(fromDate, toDate);

        LoanReportBetweenDays newLoanReport = new LoanReportBetweenDays();
        newLoanReport.setFromDate(fromDate);
        newLoanReport.setToDate(toDate);

        List<LoanReport> loanReportList = new ArrayList<>();

        loans.forEach(loan -> {
            LoanReport singleReport = new LoanReport();
            singleReport.setLoanInfo(loan);

            Customer loanCustomer = customersRepository.findByCustomerID(loan.getCustomerID()).get();
            singleReport.setCustomerInfo(loanCustomer);

            Product product = productRepository.findByProductID(loan.getProductID()).get();
            singleReport.setProduct(product);

            List<Payment> paymentsForTheLoan = paymentRepository.findByLoanID(loan.getLoanID());
            singleReport.setPayments(paymentsForTheLoan);

            loanReportList.add(singleReport);
        });

        newLoanReport.setLoanReports(loanReportList);
        return newLoanReport;
    }
}
