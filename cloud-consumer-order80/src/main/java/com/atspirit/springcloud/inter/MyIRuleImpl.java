package com.atspirit.springcloud.inter;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Valor
 * @data 2020/11/3 23:30
 */
public class MyIRuleImpl implements MyIRuleInteface {

    private AtomicInteger num = new AtomicInteger(0);


    //获取用户点击的次数
    private final int getNum() {
        int countNum;
        int next;
        do {
            countNum = num.get();
            next = countNum >= Integer.MAX_VALUE ? 0 : countNum + 1;
        } while (!num.compareAndSet(countNum, next));
        System.out.println("这是用户的第" + next + "次请求");
        return next;
    }

    @Override
    public ServiceInstance choose(List<ServiceInstance> instances) {
        int num = getNum() % instances.size();
        return instances.get(num);
    }
}
