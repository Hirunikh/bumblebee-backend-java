package com.hiruni.bumblebee.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    Optional<Order> findByCustomerID(Integer OrderID);

    List<Order> findAll();
}
