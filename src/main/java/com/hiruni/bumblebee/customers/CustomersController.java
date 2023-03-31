package com.hiruni.bumblebee.customers;

import com.hiruni.bumblebee.config.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Customers")
public class CustomersController {

    private  final CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    public List<Customers> getCustomers() {
        return customersService.getCustomers();
    }

    @GetMapping("/test-error")
    public void throwError() {
        throw new ApiError("No customers found", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public void CreateNewCustomer(@RequestBody Customers customers) {
        customersService.addNewCustomer(customers);
    }
}
