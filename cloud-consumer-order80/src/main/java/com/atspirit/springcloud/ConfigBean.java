package com.atspirit.springcloud;

import com.atspirit.springcloud.inter.MyIRuleImpl;
import com.atspirit.springcloud.inter.MyIRuleInteface;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Valor
 * @data 2020/10/27 11:58
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced   //当时用ir自定义负载均衡策略则需要注释此注解
    public RestTemplate getRestTemplte() {
        return new RestTemplate();
    }

    @Bean
    public MyIRuleInteface getMyRuleInteface() {
        return new MyIRuleImpl();
    }
}
