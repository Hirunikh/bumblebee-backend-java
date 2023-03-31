package com.hiruni.bumblebee.users;

import com.hiruni.bumblebee.customers.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

    Optional<Users> findByUserID(Integer UserID);

    List<Users> findAll();
}
