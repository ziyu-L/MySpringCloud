package com.atspirit.springcloud.service;

import com.atspirit.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Valor
 * @data 2020/10/25 20:58
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
