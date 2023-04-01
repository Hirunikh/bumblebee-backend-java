package com.hiruni.bumblebee.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Payment")
public class PaymentController {
    private  final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getPayment() {
        return paymentService.getPayment();
    }

    @PostMapping
    public void CreateNewPayment(@RequestBody Payment payment) {
        paymentService.addNewPayment(payment);
    }
}
