package com.hiruni.bumblebee.Brand;

import com.hiruni.bumblebee.Category.Category;
import com.hiruni.bumblebee.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void addNewBrand(Brand brand) {
        brandRepository.save(brand);
    }


    public List<Brand> getBrand() {
        return brandRepository.findAll();
    }
}
