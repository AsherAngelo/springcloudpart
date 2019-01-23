package com.cnpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import java.util.List;


/**
 * Created by 赵梦杰 on 2018/5/22.
 */
@RestController
@Configuration
public class police {


    //如果是Eureka使用就必须加LoadBalanced
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(method= RequestMethod.GET,value = "/hello/{name}")
    public String policeHello(@PathVariable String name){
        return "hello,"+name;
    }

    @RequestMapping(method= RequestMethod.GET,value = "/people/{name}")
    public String people(@PathVariable String name){
        RestTemplate tpl = getRestTemplate();
        String json = tpl.getForObject("http://cloud-police/hello/mengjie",String.class);
        return "people,"+json;
    }

    @RequestMapping(method= RequestMethod.GET,value = "/test")
    public String test(){
        RestTemplate tpl = new RestTemplate();
        String json = tpl.getForObject("http://127.0.0.1:9001/hello/mengjie",String.class);
        return "people,"+json;
    }
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/list")
    @ResponseBody
    public String serviceCount() {
        List<String> names = discoveryClient.getServices();
        for(String serviceId : names) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            System.out.println(serviceId + ": " + instances.size());
        }
        return "";
    }

    @GetMapping("/meta")
    @ResponseBody
    public String getMetadata() {
        List<ServiceInstance> instances = discoveryClient.getInstances("ek-provider");
        for(ServiceInstance ins : instances) {
            String name = ins.getMetadata().get("company-name");
            System.out.println(ins.getPort() + "---" + name);
        }
        return "";
    }

}
