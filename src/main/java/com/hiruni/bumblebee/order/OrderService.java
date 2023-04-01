package com.hiruni.bumblebee.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addNewOrder(Order order) {
        orderRepository.save(order);
    }


    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

}
