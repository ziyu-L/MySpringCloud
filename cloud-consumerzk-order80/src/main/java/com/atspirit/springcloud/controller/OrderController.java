package com.atspirit.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Valor
 * @data 2020/11/2 12:43
 */
@RestController
public class OrderController {

    private final static String URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/zk")
    public String getMsg() {
        return restTemplate.getForObject(URL + "/payment/zk", String.class);
    }

}
