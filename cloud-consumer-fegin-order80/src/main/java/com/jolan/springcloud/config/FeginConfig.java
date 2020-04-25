package com.jolan.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jolan80
 * @date 2020-04-21 23:29
 */
@Configuration
public class FeginConfig {
    @Bean
    Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;//fegin调用的日志级别
    }
}
