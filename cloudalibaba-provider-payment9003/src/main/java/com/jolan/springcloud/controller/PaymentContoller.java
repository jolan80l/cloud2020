package com.jolan.springcloud.controller;

import com.jolan.springcloud.entities.CommonResult;
import com.jolan.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author jolan80
 * @date 2020-05-13 22:50
 */
@RestController
@Slf4j
public class PaymentContoller {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<Long, Payment>();
    static{
        hashMap.put(1L, new Payment(1L, "1"));
        hashMap.put(2L, new Payment(2L, "2"));
        hashMap.put(3L, new Payment(3L, "3"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult result = new CommonResult(200, "from mysql, serverPort: " + serverPort, payment);
        return result;
    }
}
