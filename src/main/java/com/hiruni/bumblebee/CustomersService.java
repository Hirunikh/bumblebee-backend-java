package com.hiruni.bumblebee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public static void addnewCustomer(Customers customers) {
        System.out.println(customers);
    }


    public List<Customers> getCustomers() {
        return customersRepository.findAll();
    }
}
