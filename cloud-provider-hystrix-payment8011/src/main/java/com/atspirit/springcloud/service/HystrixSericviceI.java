package com.atspirit.springcloud.service;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Valor
 * @data 2020/11/5 11:46
 */
@Service
public interface HystrixSericviceI {

    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    CommonResult<Payment> getPaymentTimeOutById(@PathVariable("id") Long id);

    String paymentCircuitBreaker(@PathVariable("id") Long id);
    //当程序出现超时以及异常时的后备方法
    //    String getPaymentTimeOutById_Handler();

}
