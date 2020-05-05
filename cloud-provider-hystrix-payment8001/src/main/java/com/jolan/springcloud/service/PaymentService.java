package com.jolan.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author jolan80
 * @date 2020-04-23 22:51
 */
@Service
public class PaymentService {
    public String paymentInfoOk(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoOk, id:" + id + "o(∩_∩)o 哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout(Integer id){
//        int i = 10 / 0;
        int time = 5;
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoTimeout, id:" + id + "o(∩_∩)o 哈哈" + "  耗时" + time + "秒钟";
    }


    public String paymentInfoTimeoutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " 系统调用超时或报错，请稍后再试, id:" + id + "(┬＿┬)";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("******id不能为负数");
        }
        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNum;
    }

    public String paymentCircuitBreakerFallback(Integer id){
        return "id不能为负数，请稍后再试，/(┬＿┬)/, id:" + id;
    }
}
