package com.atspirit.springcloud.service.imp;

import com.atspirit.springcloud.dao.PaymentDao;
import com.atspirit.springcloud.entities.Payment;
import com.atspirit.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Valor
 * @data 2020/10/25 20:59
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
