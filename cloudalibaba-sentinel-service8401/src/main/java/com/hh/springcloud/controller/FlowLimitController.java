package com.hh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class FlowLimitController
{

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }
    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }
    @GetMapping("/testhotkey")
    @SentinelResource(value = "testhotkey",blockHandler = "deal_testhotkey")
    public String testhotkey(@RequestParam(value = "p1",required = false) String p1 , @RequestParam(value = "p2",required = false)  String p2)
    {
        return "-------------->testhotkey";
    }
    public String deal_testhotkey(String p1 , String p2, BlockException e)
    {
        return "-------------->deal_testhotkey";
    }
}