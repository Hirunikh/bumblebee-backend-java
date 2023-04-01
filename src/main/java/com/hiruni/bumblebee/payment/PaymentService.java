package com.hiruni.bumblebee.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void addNewPayment(Payment payment) {
        paymentRepository.save(payment);
    }


    public List<Payment> getPayment() {
        return paymentRepository.findAll();
    }
}
