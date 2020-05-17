package com.jolan.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jolan80
 * @date 2020-05-17 16:34
 */
@Configuration
@MapperScan({"com.jolan.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
