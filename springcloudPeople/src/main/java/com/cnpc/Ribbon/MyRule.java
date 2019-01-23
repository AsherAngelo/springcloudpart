package com.cnpc.Ribbon;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * Created by 赵梦杰 on 2018/5/25.
 */
public class MyRule implements IRule{

    private ILoadBalancer lb;

    public Server choose(Object o) {
        Random random = new Random();
        int num = random.nextInt(10);
        List<Server> servers = lb.getAllServers();
        if(num>7){
            return servers.get(1);
        }
        return servers.get(0);
    }

    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.lb = iLoadBalancer;
    }

    public ILoadBalancer getLoadBalancer() {
        return this.lb;
    }
}
