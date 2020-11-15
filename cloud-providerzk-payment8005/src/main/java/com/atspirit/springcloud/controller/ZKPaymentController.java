package com.atspirit.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Valor
 * @data 2020/11/3 14:19
 */
@RestController
public class ZKPaymentController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk() {
        return "SpringCloud with Zookpee" + port + ",UUID:" + UUID.randomUUID().toString();
    }

}
