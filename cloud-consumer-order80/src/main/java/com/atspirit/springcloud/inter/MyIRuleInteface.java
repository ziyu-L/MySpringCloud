package com.atspirit.springcloud.inter;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Valor
 * @data 2020/11/3 23:24
 */
//@Service
public interface MyIRuleInteface {

    ServiceInstance choose(List<ServiceInstance> instances);

}
