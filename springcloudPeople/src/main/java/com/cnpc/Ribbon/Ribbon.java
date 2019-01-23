package com.cnpc.Ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * Created by 赵梦杰 on 2018/5/22.
 */
@RestController
@Configuration
public class Ribbon {


    //如果是Eureka使用就必须加LoadBalanced
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(method= RequestMethod.GET,value = "/ribbon")
    public String people(){
        RestTemplate tpl = getRestTemplate();
        String json = tpl.getForObject("http://cloud-police/ribbon",String.class);
        return "people,"+json;
    }


}
