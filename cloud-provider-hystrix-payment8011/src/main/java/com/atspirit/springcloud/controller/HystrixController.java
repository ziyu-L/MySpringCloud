package com.atspirit.springcloud.controller;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.service.HystrixSericviceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Valor
 * @data 2020/11/5 11:50
 */
@RestController
@Slf4j
public class HystrixController {

    @Resource
    private HystrixSericviceI hystrixSericviceI;

    @GetMapping(value = "payment/hystrix/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return hystrixSericviceI.getPaymentById(id);
    }

    @GetMapping(value = "payment/hystrix/timeout/get/{id}")
    CommonResult<Payment> getPaymentTimeOutById(@PathVariable("id") Long id) {
        return hystrixSericviceI.getPaymentTimeOutById(id);
    }

    @GetMapping(value = "payment/hystrix/circuit/get/{id}")
    String paymentCircuitBreaker(@PathVariable("id") Long id) {
        return hystrixSericviceI.paymentCircuitBreaker(id);
    }

}
