package com.atspirit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Valor
 * @data 2020/11/2 16:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulMain80.class, args);
    }

}
