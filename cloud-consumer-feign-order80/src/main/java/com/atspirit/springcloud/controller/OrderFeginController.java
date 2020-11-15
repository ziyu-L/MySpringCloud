package com.atspirit.springcloud.controller;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.service.FeignServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Valor
 * @data 2020/11/4 17:00
 */
@RestController
public class OrderFeginController {

    @Resource
    private FeignServiceI feignServiceI;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return feignServiceI.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public Integer getTimeOutPort() {
        System.out.println("111");
        return feignServiceI.getTimeOutPort();
    }

}
