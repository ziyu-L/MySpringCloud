package com.atspirit.springcloud.service;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.service.serviceImpl.OrderHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Valor
 * @data 2020/11/5 16:18
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = OrderHystrixServiceImpl.class)
public interface OrderHystrixServiceI {

    @GetMapping(value = "/payment/hystrix/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/hystrix/timeout/get/{id}")
    CommonResult<Payment> getPaymentTimeOutById(@PathVariable("id") Long id);

    @GetMapping(value = "payment/hystrix/circuit/get/{id}")
    String paymentCircuitBreaker(@PathVariable("id") Long id);
}
