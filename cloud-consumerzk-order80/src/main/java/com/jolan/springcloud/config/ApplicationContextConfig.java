package com.jolan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author jolan80
 * @date 2020-04-19 10:20
 */
@Configuration
public class ApplicationContextConfig {
    @Bean//将RestTemplate注册到spring容器
    @LoadBalanced//启动负载配置
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
