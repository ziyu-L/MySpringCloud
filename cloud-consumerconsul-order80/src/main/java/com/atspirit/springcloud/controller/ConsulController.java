package com.atspirit.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Valor
 * @data 2020/11/2 18:30
 */
@RestController
public class ConsulController {

    private final static String URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String getMsg() {
        return restTemplate.getForObject(URL+"/payment/consul", String.class);
    }

}
