package com.hiruni.bumblebee.loyalty;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LoyaltyRepository extends CrudRepository<Loyalty, Integer> {

    Optional<Loyalty> findByCustomerID(Integer LoyaltyID);

    List<Loyalty> findAll();
}
