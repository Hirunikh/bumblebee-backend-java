package com.hiruni.bumblebee.loan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

    Optional<Loan> findByLoanID(Integer LoanID);

    List<Loan> findAll();

    List<Loan> findByPaymentDueDateBetween(LocalDate fromDate, LocalDate toDate);

    List<Loan> findByCustomerIDAndPaymentDueDateAfter(Integer customerID, LocalDate today);
}
