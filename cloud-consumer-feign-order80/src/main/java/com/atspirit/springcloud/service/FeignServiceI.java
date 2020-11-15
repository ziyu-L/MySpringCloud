package com.atspirit.springcloud.service;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Valor
 * @data 2020/11/4 16:56
 */
@Service
@FeignClient(value = "cloud-payment-service")
public interface FeignServiceI {

    @GetMapping(value = "/payment/timeout")
    Integer getTimeOutPort();

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
