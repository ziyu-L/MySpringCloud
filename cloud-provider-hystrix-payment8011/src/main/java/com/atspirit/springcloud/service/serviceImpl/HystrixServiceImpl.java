package com.atspirit.springcloud.service.serviceImpl;

import cn.hutool.core.util.IdUtil;
import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.service.FeignServiceI;
import com.atspirit.springcloud.service.HystrixSericviceI;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * @author Valor
 * @data 2020/11/5 11:49
 */
@Component
public class HystrixServiceImpl implements HystrixSericviceI {

    @Resource
    private FeignServiceI feignServiceI;

    @Value("${server.port}")
    private Integer port;

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return feignServiceI.getPaymentById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPaymentTimeOutById_Handler",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public CommonResult<Payment> getPaymentTimeOutById(Long id) {
        //测试一：异常测试
        //        int i = 1 / 0;
        //测试二：超时测试
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return feignServiceI.getPaymentById(id);
    }

    public CommonResult<Payment> getPaymentTimeOutById_Handler(Long id) {
        CommonResult<Payment> payment = new CommonResult<>(404, "当前程序port:" + port + "出现请求超时或者程序异常的情况，请重试或者联系管理员！");
        return payment;
    }

    //===========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),})
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能为负数");
        }
        String uuid = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，UUID：" + uuid + ",payment:" + feignServiceI.getPaymentById(id);
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Long id) {
        return "id不能为负数，请稍后再试，id:" + id;
    }
}
