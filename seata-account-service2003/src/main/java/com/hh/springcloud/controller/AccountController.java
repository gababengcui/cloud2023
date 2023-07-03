package com.hh.springcloud.controller;

import com.hh.springcloud.entities.CommonResult;
import com.hh.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("used") BigDecimal used){
        accountService.decrease(userId,used);
        return new CommonResult(200,"扣减账户余额成功！");
    }
}
