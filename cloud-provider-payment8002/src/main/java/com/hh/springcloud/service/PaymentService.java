package com.hh.springcloud.service;

import com.hh.springcloud.entities.Payment;


public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById( Long id);
}
