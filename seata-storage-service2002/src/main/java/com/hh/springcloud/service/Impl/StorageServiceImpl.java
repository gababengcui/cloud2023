package com.hh.springcloud.service.Impl;

import com.hh.springcloud.dao.StorageDao;
import com.hh.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
      log.info("-------->库存开始减少");
      storageDao.decrease(productId,count);
        log.info("-------->库存减少完成");
    }
}
