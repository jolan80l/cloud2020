package com.jolan.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jolan80
 * @date 2020-04-20 23:09
 */
@Service(value="loadBalancer")
public class LoadBalancerImpl implements ILoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

//    @Resource
//    private DiscoveryClient discoveryClient;
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
//        for(ServiceInstance instance : instances){
//
//        }
        return serviceInstances.get(index);
    }

    public final int getAndIncrement(){
        int current;
        int next;

        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***********next:" + next);
        return next;
    }

}
