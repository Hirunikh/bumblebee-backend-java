package com.hiruni.bumblebee.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

    Optional<Inventory> findByInventoryID(Integer InventoryID);

    List<Inventory> findAll();
}
