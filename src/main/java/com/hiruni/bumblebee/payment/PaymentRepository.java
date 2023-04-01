package com.hiruni.bumblebee.payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository  extends CrudRepository<Payment, Integer> {

    Optional<Payment> findByPaymentID(Integer PaymentID);

    List<Payment> findAll();

    List<Payment> findByLoanID(Integer LoanID);
}
