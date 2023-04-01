package com.hiruni.bumblebee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Product")
public class ProductController {

    private  final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProduct() {
        return productService.getProduct();
    }

    @PostMapping
    public void CreateNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }
    @DeleteMapping(path = "{ProductID}")
    public void deleteProduct (
            @PathVariable ("ProductID") Integer productID){
        productService.deleteProduct(productID);
    }

    @PutMapping(path = "{ProductID}")
    public void updateProduct(
            @PathVariable("ProductID") Integer productID,
            @RequestParam String productName){
        productService.updateProduct(productID,productName);
    }
}
