package com.hh.springcloud.service.Impl;

import com.hh.springcloud.dao.AccountDao;
import com.hh.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal used) {

      log.info("---------->用户余额开始扣除");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(30); } catch (InterruptedException e) { e.printStackTrace(); }
      accountDao.decrease(userId,used);
      log.info("--------->余额扣除完成");
    }
}
