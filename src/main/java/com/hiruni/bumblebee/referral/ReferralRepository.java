package com.hiruni.bumblebee.referral;

import com.hiruni.bumblebee.customers.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReferralRepository extends CrudRepository<Referral, Integer> {


    Optional<Referral> findByReferralID(Integer ReferralID);

    List<Referral> findAll();
}
