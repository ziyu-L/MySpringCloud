package com.atspirit.springcloud.controller;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.service.OrderHystrixServiceI;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Valor
 * @data 2020/11/5 16:20
 */
@RestController
public class OrderHystrixController {

    @Autowired
    private OrderHystrixServiceI orderHystrixServiceI;

    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/consumer/payment/hystrix/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return orderHystrixServiceI.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/get/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentTimeOutById_FallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    CommonResult<Payment> getPaymentTimeOutById(@PathVariable("id") Long id) {
//        int i = 1 / 0;
        return orderHystrixServiceI.getPaymentTimeOutById(id);
    }

    CommonResult<Payment> getPaymentTimeOutById_FallbackMethod(@PathVariable("id") Long id) {
        return new CommonResult<>(404,
                "当前程序port:" + port + "出现请求超时或者程序异常的情况，请重试或者联系管理员！");
    }

    //===熔断器
    @GetMapping(value = "payment/hystrix/circuit/get/{id}")
    String paymentCircuitBreaker(@PathVariable("id") Long id) {
        return orderHystrixServiceI.paymentCircuitBreaker(id);
    }
}
