package com.jolan.springcloud.service;

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

    public String paymentInfoTimeout(Integer id){
        int time = 3;
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoOk, id:" + id + "o(∩_∩)o 哈哈" + "  耗时" + time + "秒钟";
    }
}
