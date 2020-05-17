package com.jolan.springcloud.alibaba.service.impl;

import com.jolan.springcloud.alibaba.dao.IOrderDao;
import com.jolan.springcloud.alibaba.domain.Order;
import com.jolan.springcloud.alibaba.service.IAccountService;
import com.jolan.springcloud.alibaba.service.IOrderSerivce;
import com.jolan.springcloud.alibaba.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jolan80
 * @date 2020-05-17 11:43
 */
@Service("orderService")
@Slf4j
public class OrderServiceImpl  implements IOrderSerivce {

    @Resource
    private IOrderDao orderDao;
    @Resource
    private IAccountService accountService;
    @Resource
    private IStorageService storageService;



    @Override
    public void create(Order order) {
        log.info("----->开始新建订单：", order);
        orderDao.create(order);

        log.info("----->订单微服务开始调用库存，做扣减count");
        storageService.decrase(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，end");

        log.info("----->订单微服务开始调用账户，做扣减money");
        accountService.decrase(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束，o(∩_∩)o 哈哈");


    }
}
