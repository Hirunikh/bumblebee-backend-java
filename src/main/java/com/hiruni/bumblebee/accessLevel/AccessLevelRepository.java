package com.hiruni.bumblebee.accessLevel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccessLevelRepository extends CrudRepository<AccessLevel, Integer> {

    Optional<AccessLevel> findByAccessLevelID(Integer AccessLevelID);

    List<AccessLevel> findAll();
}
