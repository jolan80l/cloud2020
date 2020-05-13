package com.jolan.springcloud.com.jolan.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author jolan80
 * @date 2020-05-10 10:34
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() throws InterruptedException {
//        TimeUnit.MILLISECONDS.sleep(800);//按线程数限制
        return "---------testA";
    }

    @GetMapping(value = "/testB")
    public String testB(){
        log.info(Thread.currentThread().getName() + "\t" + ".........tesB");
        return "---------testB";
    }

    @GetMapping(value = "/testC")
    public String testC(){

        int age = 10/0;
        log.info("testC 测试异常比例");
        return "---------testC";
    }

    @GetMapping(value = "/testD")
    public String testD(){

        try{
            TimeUnit.MILLISECONDS.sleep(1000);//测试降级
        }catch(Exception e){
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "---------testD";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value="testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false)String p1,
                             @RequestParam(value = "p2", required = false)String p2){
//        int age = 10/0;  //运行时异常SentinelResource不做处理
        return "---------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "---------deal_testHotKey,(┬＿┬)";
    }
}
