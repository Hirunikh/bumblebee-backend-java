package com.hiruni.bumblebee.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Order")
public class OrderController {
    private  final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrder() {
        return orderService.getOrder();
    }

    @PostMapping
    public void CreateNewOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
    }
}

