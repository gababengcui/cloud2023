package com.hh.springcloud.service.impl;

import com.hh.springcloud.dao.OrderDao;
import com.hh.springcloud.domain.Order;
import com.hh.springcloud.service.AccountService;
import com.hh.springcloud.service.OrderService;
import com.hh.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------->开始创建订单");
        orderDao.create(order);
        log.info("------->创建订单调用库存，做减法");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->订单微服务调用账户扣钱");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-------->修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("-------->结束");
    }
}
