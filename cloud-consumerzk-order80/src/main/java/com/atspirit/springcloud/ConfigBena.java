package com.atspirit.springcloud;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Valor
 * @data 2020/11/2 12:47
 */
@Configuration
public class ConfigBena {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplte() {
        return new RestTemplate();
    }

}
