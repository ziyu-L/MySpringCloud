package com.atspirit.springcloud.controller;

import com.atspirit.springcloud.entities.CommonResult;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.inter.MyIRuleInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author Valor
 * @data 2020/10/27 11:56
 */
@RestController
public class OrderController {

    //    private static final String DEFUALTURL = "http://127.0.0.1:8001";
    private static final String DEFUALTURL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyIRuleInteface myIRuleInteface;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<RestTemplate> create(Payment payment) {
        return restTemplate.postForObject(DEFUALTURL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<RestTemplate> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(DEFUALTURL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/ir")
    public String getPort() {
        List<ServiceInstance> instances =
                discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance serviceInstance = myIRuleInteface.choose(instances);
        if (serviceInstance == null) {
            return "--------->serviceInstance为null";
        }
        URI uri = serviceInstance.getUri();
        System.out.println("--------------->"+uri);
        System.out.println("--------------->"+serviceInstance.getHost());
        System.out.println(uri + "/payment/ir");
        return restTemplate.getForObject(uri + "/payment/ir", String.class);
    }

}
