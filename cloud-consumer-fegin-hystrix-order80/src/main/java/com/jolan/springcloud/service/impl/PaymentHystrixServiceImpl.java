package com.jolan.springcloud.service.impl;

import com.jolan.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @author jolan80
 * @date 2020-04-28 22:42
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentHystrixService-paymentInfoOk 超时或报错";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentHystrixService-paymentInfoTimeout 超时或报错";
    }
}
