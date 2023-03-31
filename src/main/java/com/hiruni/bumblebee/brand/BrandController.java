package com.hiruni.bumblebee.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Brand")
public class BrandController {

    private  final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getBrand() {
        return brandService.getBrand();
    }

    @PostMapping
    public void CreateNewBrand(@RequestBody Brand brand)
    {
        brandService.addNewBrand(brand);
    }

    @DeleteMapping(path = "{BrandID}")
    public void deleteBrand (
            @PathVariable ("BrandID") Integer brandID){
        brandService.deleteBrand(brandID);
    }

    @PutMapping(path = "{BrandID}")
    public void updateBrand(
            @PathVariable("BrandID") Integer brandID,
            @RequestParam String brandName){
        brandService.updateBrand(brandID,brandName);
    }
}
