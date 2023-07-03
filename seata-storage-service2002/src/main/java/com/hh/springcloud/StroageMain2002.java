package com.hh.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.hh.springcloud.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StroageMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(StroageMain2002.class,args);
    }
}
