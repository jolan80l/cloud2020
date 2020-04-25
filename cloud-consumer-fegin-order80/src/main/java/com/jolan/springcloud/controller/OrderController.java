package com.jolan.springcloud.controller;

import com.jolan.springcloud.entities.CommonResult;
import com.jolan.springcloud.entities.Payment;
import com.jolan.springcloud.service.PaymentFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jolan80
 * @date 2020-04-21 22:58
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentFeginService paymentFeginService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        return paymentFeginService.getPaymentId(id);

    }

    @GetMapping("/consumer/payment/fegin/timeout")
    public String paymentFeginTimeout(){
        //openFegin客户端默认等待1s
        return paymentFeginService.paymentFeginTimeout();

    }
}
