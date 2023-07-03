package com.hh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncreament(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 214748367? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
            System.out.println(next);
            return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncreament() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}