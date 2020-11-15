package com.atspirit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Valor
 * @data 2020/11/2 12:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZKOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ZKOrderMain80.class, args);
    }

}
