package com.atspirit.IR;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Valor
 * @data 2020/11/3 23:09
 */
@Configuration
public class MyIRule {

    @Bean
    public IRule getIRule() {
        return new RoundRobinRule();
    }
}
