package com.hiruni.bumblebee.product;

import com.hiruni.bumblebee.customers.Customers;
import com.hiruni.bumblebee.customers.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
