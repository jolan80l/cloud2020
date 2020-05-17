package com.jolan.springcloud.alibaba.dao;

import com.jolan.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jolan80
 * @date 2020-05-17 10:26
 */
@Mapper
public interface IOrderDao {
    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从0修改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
