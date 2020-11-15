package com.atspirit.springcloud.service.serviceImpl;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.service.OrderHystrixServiceI;
import org.springframework.stereotype.Component;

/**
 * @author Valor
 * @data 2020/11/6 0:04
 */
@Component
public class OrderHystrixServiceImpl implements OrderHystrixServiceI {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(404, "我是80端口，因为服务器宕机而导致的问题，请联系相关人员检查！");
    }

    @Override
    public CommonResult<Payment> getPaymentTimeOutById(Long id) {
        return new CommonResult<>(404, "我是80端口，因为服务器超时或者出现错误而导致的问题，请联系相关人员检查！");
    }

    @Override
    public String paymentCircuitBreaker(Long id) {
        return "我是80端口,正在调用paymentCircuitBreaker()，出现错误请联系相关人员检查！";
    }
}
