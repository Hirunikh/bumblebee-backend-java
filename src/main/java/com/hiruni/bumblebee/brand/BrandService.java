package com.hiruni.bumblebee.brand;

import com.hiruni.bumblebee.category.Category;
import com.hiruni.bumblebee.config.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void deleteBrand(Integer brandID) {
        boolean exists = brandRepository.existsById(brandID);
        if(!exists){
            throw new ApiError("Brand with this ID does not exist", HttpStatus.BAD_REQUEST);
        }
        brandRepository.deleteById(brandID);
    }

    @Transactional
    public void updateBrand(Integer brandID, String newBrandName) {
        Brand brand = brandRepository.findByBrandID(brandID)
                .orElseThrow( () -> new ApiError("This Brand does not exist.", HttpStatus.BAD_REQUEST));
        if (newBrandName != null && newBrandName.length() > 0 && !newBrandName.equals(brand.getBrandName())){
            brand.setBrandName(newBrandName);
            brandRepository.save(brand);
        }
    }
}
