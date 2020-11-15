package com.atspirit.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Valor
 * @data 2020/11/3 16:16
 */
@RestController
public class ConsulPaymentController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/payment/consul")
    public String getMsg() {
        return "Hello World cloud-providerconsul-payment:" + port + "," + UUID.randomUUID().toString();
    }

}
