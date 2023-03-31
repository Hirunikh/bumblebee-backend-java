package com.hiruni.bumblebee.product;

import com.hiruni.bumblebee.customers.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends CrudRepository<Product, Integer> {

    Optional<Product> findByProductID(Integer ProductID);

    List<Product> findAll();
}
