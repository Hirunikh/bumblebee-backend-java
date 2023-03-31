package com.hiruni.bumblebee.Brand;

import com.hiruni.bumblebee.Brand.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {

    Optional<Brand> findByBrandID(Integer BrandID);

    List<Brand> findAll();

}
