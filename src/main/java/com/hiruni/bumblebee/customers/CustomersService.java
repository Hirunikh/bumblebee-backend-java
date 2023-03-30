package com.hiruni.bumblebee.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public void addNewCustomer(Customers customers) {
        customersRepository.save(customers);
    }


    public List<Customers> getCustomers() {
        return customersRepository.findAll();
    }
}
