package com.jolan.springcloud.alibaba.controller;

import com.jolan.springcloud.alibaba.domain.CommonResult;
import com.jolan.springcloud.alibaba.domain.Order;
import com.jolan.springcloud.alibaba.service.IOrderSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jolan80
 * @date 2020-05-17 16:30
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private IOrderSerivce orderSerivce;

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order){
        orderSerivce.create(order);
        return new CommonResult(200, "创建订单成功");
    }
}
