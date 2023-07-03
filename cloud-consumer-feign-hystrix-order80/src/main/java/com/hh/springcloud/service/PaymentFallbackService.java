package com.hh.springcloud.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallbackService fallback ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------PaymentFallbackService fallback TimeOut ";
    }
}
