package com.hh.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
 public interface AccountDao {
void decrease(@Param("userId") Long userId,@Param("used") BigDecimal used);
}
