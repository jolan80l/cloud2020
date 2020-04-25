package com.jolan.springcloud.service.impl;

import com.jolan.springcloud.dao.PaymentDao;
import com.jolan.springcloud.entities.Payment;
import com.jolan.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jolan80
 * @date 2020-04-13 23:42
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
