package com.hiruni.bumblebee.loan;

import com.hiruni.bumblebee.customers.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

    Optional<Loan> findByLoanID(Integer LoanID);

    List<Loan> findAll();
}
