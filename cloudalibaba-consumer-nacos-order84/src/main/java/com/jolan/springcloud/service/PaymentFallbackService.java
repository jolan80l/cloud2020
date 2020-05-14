package com.jolan.springcloud.service;

import com.jolan.springcloud.entities.CommonResult;
import com.jolan.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author jolan80
 * @date 2020-05-14 22:57
 */
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
