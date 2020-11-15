package com.atspirit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Valor
 * @data 2020/11/3 14:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZKPaymentMain8005 {

    public static void main(String[] args) {
        SpringApplication.run(ZKPaymentMain8005.class, args);
    }

}
