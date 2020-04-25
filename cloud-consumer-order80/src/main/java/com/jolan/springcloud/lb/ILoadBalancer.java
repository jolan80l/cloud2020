package com.jolan.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author jolan80
 * @date 2020-04-20 23:06
 */
public interface ILoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}
