package com.jolan.springcloud.service;

import com.jolan.springcloud.entities.CommonResult;
import com.jolan.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jolan80
 * @date 2020-04-21 23:00
 */
@Component
@FeignClient(value="CLOUD-PROVIDER-PAYMENT")//value代表要调用的服务名称
public interface PaymentFeginService {

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/fegin/timeout")
    public String paymentFeginTimeout();
}
