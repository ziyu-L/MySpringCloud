package com.atspirit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Valor
 * @data 2020/11/3 16:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentMain8007 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentMain8007.class, args);
    }

}
