package com.atspirit.springcloud.controller;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.service.OrderHystrixServiceI;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Valor
 * @data 2020/11/5 16:20
 * <p>
 * 1.测试1/0是否会启动我的global方法
 * 2、测试服务端超时是否会调用我的方法
 */
@RestController
@DefaultProperties(defaultFallback = "getPaymentTimeOutById_Global_FallbackMethod")
public class OrderHystrixControllerGlobal {

    @Autowired
    private OrderHystrixServiceI orderHystrixServiceI;

    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/consumer/payment/hystrix/global/get/{id}")
    @HystrixCommand
    CommonResult<Payment> getPaymentTimeOutById(@PathVariable("id") Long id) {
        //        int i = 1 / 0;
        return orderHystrixServiceI.getPaymentTimeOutById(id);
    }

    CommonResult<Payment> getPaymentTimeOutById_Global_FallbackMethod() {
        return new CommonResult<>(404,
                "当前处理问题的是Global方法，当前程序port:" + port + "出现请求超时或者程序异常的情况，请重试或者联系管理员！");
    }

    //===熔断器
    @GetMapping(value = "/consumer/payment/hystrix/global/circuit/get/{id}")
    @HystrixCommand
    CommonResult<Payment> paymentCircuitBreaker(@PathVariable("id") Long id) {
        return new CommonResult<>(404, orderHystrixServiceI.paymentCircuitBreaker(id));
    }
}
