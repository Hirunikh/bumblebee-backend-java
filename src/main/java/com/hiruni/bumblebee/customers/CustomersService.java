package com.hiruni.bumblebee.customers;

import com.hiruni.bumblebee.config.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public void addNewCustomer(Customers newCustomer) {
        Optional<Customers> existingCustomer = customersRepository.findByEmail(newCustomer.getEmail());

        if (existingCustomer.isPresent()) {
            throw new ApiError("An account from this email already exist.", HttpStatus.BAD_REQUEST);
        }

        long age = LocalDate.from(newCustomer.getDob()).until(LocalDate.now(), ChronoUnit.YEARS);
        if (age < 18) {
            throw new ApiError("In order to create an account you should be at least 18.", HttpStatus.BAD_REQUEST);
        }

        newCustomer.setLoanBalance(0.0);
        newCustomer.setUsedAmount(0.0);
        newCustomer.setCreditLimit(15000.0);

        customersRepository.save(newCustomer);
    }

    public List<Customers> getCustomers() {
        return customersRepository.findAll();
    }
}
