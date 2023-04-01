package com.hiruni.bumblebee.customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepository  extends CrudRepository<Customer, Integer> {

    Optional<Customer> findByCustomerID(Integer CustomerID);

    Optional<Customer> findByEmail(String email);

    List<Customer> findAll();
}
