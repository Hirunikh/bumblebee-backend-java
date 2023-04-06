package com.hiruni.bumblebee.product;

import com.hiruni.bumblebee.config.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void deleteProduct(Integer productID) {
        boolean exists = productRepository.existsById(productID);
        if(!exists){
            throw new ApiError("Product with this ID does not exist", HttpStatus.BAD_REQUEST);
        }
        productRepository.deleteById(productID);
    }

    @Transactional
    public void updateProduct(Integer productID, Product newProduct) {
        Product product = productRepository.findByProductID(productID)
                .orElseThrow( () -> new ApiError("This Product does not exist.", HttpStatus.BAD_REQUEST));
        newProduct.setProductID(productID);
        productRepository.save(newProduct);
    }
}
