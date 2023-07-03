package com.hh.springcloud.controller;

import com.hh.springcloud.entities.CommonResult;
import com.hh.springcloud.entities.Payment;
import com.hh.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {
    @Resource
private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
public CommonResult<Payment> getPaymentId(@PathVariable("id")Long id) {
return paymentFeignService.getPaymentById(id);
}
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }
}
