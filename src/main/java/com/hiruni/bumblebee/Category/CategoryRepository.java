package com.hiruni.bumblebee.Category;

import com.hiruni.bumblebee.Category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Optional<Category> findByCategoryID(Integer CategoryID);

    List<Category> findAll();

}
