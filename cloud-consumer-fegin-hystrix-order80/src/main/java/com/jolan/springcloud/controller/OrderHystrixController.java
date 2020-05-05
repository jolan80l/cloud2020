package com.jolan.springcloud.controller;

import com.jolan.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jolan80
 * @date 2020-04-23 23:21
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/customer/payment//hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoOk(id);
        log.info("********reslut:{}", result);
        return result;
    }

//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @GetMapping(value = "/customer/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoTimeout(id);
        log.info("********reslut:{}", result);
        return result;
    }

    public String paymentInfoTimeoutHandler(Integer id){
        return "我是订单侧80，服务调用超时或自身报错，(┬＿┬)";
    }

    public String paymentGlobalFallbackMethod(){
        return "全局异常处理";
    }
}
