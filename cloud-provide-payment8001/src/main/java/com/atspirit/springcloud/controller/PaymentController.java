package com.atspirit.springcloud.controller;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Valor
 * @data 2020/10/25 21:02
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，端口号：" + port, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功，端口号：" + port, payment);
        } else {
            return new CommonResult(444, "没有对应的记录，查询id:" + id + "端口号：" + port, null);
        }
    }


    @GetMapping(value = "payment/discovery")
    public Object getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*******server:" + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.debug(instance.getServiceId() + "---->" + instance.getUri() + ":" + instance.getPort() + "---->" + instance.getHost());
            }
        }
        return this.discoveryClient;
    }


    @GetMapping(value = "/payment/ir")
    public Integer getPort() {
        return port;
    }

}
