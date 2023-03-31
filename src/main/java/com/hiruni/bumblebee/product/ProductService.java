package com.hiruni.bumblebee.product;

import com.hiruni.bumblebee.category.Category;
import com.hiruni.bumblebee.config.ApiError;
import com.hiruni.bumblebee.customers.Customers;
import com.hiruni.bumblebee.customers.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    public void updateProduct(Integer productID, String newProductName) {
        Product product = productRepository.findByProductID(productID)
                .orElseThrow( () -> new ApiError("This Category does not exist.", HttpStatus.BAD_REQUEST));
        if (newProductName != null && newProductName.length() > 0 && !newProductName.equals(product.getProductName())){
            product.setProductName(newProductName);
            productRepository.save(product);
        }
    }
}
