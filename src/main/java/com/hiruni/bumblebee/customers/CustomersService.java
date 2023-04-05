package com.hiruni.bumblebee.customers;

import com.hiruni.bumblebee.config.ApiError;
import com.hiruni.bumblebee.loan.*;
import com.hiruni.bumblebee.payment.Payment;
import com.hiruni.bumblebee.payment.PaymentRepository;
import com.hiruni.bumblebee.product.Product;
import com.hiruni.bumblebee.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    private final CustomersRepository customersRepository;
    private final LoanRepository loanRepository;

    private final ProductRepository productRepository;

    private final PaymentRepository paymentRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    @Autowired
    public CustomersService(CustomersRepository customersRepository, LoanRepository loanRepository,
                            ProductRepository productRepository, PaymentRepository paymentRepository) {

        this.customersRepository = customersRepository;
        this.loanRepository = loanRepository;
        this.productRepository = productRepository;
        this.paymentRepository = paymentRepository;
    }

    public void addNewCustomer(Customer newCustomer) {
        Optional<Customer> existingCustomer = customersRepository.findByEmail(newCustomer.getEmail());

        if (existingCustomer.isPresent()) {
            throw new ApiError("An account from this email already exist.", HttpStatus.BAD_REQUEST);
        }

        long age = LocalDate.from(newCustomer.getDob()).until(LocalDate.now(), ChronoUnit.YEARS);
        if (age < 18) {
            throw new ApiError("In order to create an account you should be at least 18.", HttpStatus.BAD_REQUEST);
        }

       // newCustomer.setLoanBalance(0.0);
        newCustomer.setUsedAmount(0.0);
        newCustomer.setCreditLimit(15000.0);
        newCustomer.setInstallmentPlan("3 months");

        String encodedPassword = bCryptPasswordEncoder.encode(newCustomer.getPassword());
        newCustomer.setPassword(encodedPassword);

        customersRepository.save(newCustomer);
    }

    public List<Customer> getCustomers() {
        return customersRepository.findAll();
    }

    public List<CustomerLoan> getLoansForCustomer(Integer customerID) {
        LocalDate today = LocalDate.now();

        List<Loan> customerLoans = loanRepository.findByCustomerIDAndPaymentDueDateAfter(customerID, today);

        List<CustomerLoan> customerReportList = new ArrayList<>();

        customerLoans.forEach(customerLoan -> {
            CustomerLoan singleCustomerReport = new CustomerLoan();
            singleCustomerReport.setLoanInfo(customerLoan);

            Product product = productRepository.findByProductID(customerLoan.getProductID()).get();
            singleCustomerReport.setProduct(product);

            List<Payment> paymentsForTheLoan = paymentRepository.findByLoanID(customerLoan.getLoanID());
            singleCustomerReport.setPayments(paymentsForTheLoan);

            customerReportList.add(singleCustomerReport);
        });

        return customerReportList;
    }
}
