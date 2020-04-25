package com.jolan.springcloud.service;

import com.jolan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author jolan80
 * @date 2020-04-13 23:41
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
