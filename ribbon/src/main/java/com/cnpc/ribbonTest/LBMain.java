package com.cnpc.ribbonTest;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赵梦杰 on 2018/5/25.
 */
public class LBMain {
    public static void main(String[] args) {
        ILoadBalancer loadBalancer = new BaseLoadBalancer();
        List<Server> list = new ArrayList<Server>();
        list.add(new Server("localhost", 8080));
        list.add(new Server("localhost", 8081));
        loadBalancer.addServers(list);
        for(int i=0;i<10;i++){
            Server s = loadBalancer.chooseServer(null);
            System.out.println(s);
        }
    }

}
