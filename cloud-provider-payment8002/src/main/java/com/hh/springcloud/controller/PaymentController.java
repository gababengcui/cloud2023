package com.hh.springcloud.controller;

import com.hh.springcloud.entities.CommonResult;
import com.hh.springcloud.entities.Payment;
import com.hh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***********"+payment);
        log.info("***********");
        if (result > 0){
            return new CommonResult(200,"success，服务端口"+serverPort,result);
        }else {
            return new CommonResult<>(500,"插入失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            return new CommonResult(200,"查询成功，服务端口"+serverPort,payment);
        }else {
            return new CommonResult(500,"null",null);
        }

    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
