package com.atspirit.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Valor
 * @data 2020/11/1 20:49
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk() {
        return "SpringCloud with Zookpee" + port + ",UUID:" + UUID.randomUUID().toString();
    }

}
