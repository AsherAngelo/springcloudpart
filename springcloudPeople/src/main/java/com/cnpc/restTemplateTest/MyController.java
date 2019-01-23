package com.cnpc.restTemplateTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 赵梦杰 on 2018/5/27.
 */
@RestController
@Configuration
public class MyController {
    @Bean
    @MyLoadBalanced
    public RestTemplate tplA() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/call", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String call() {
        RestTemplate tpl = tplA();
        String json = tpl.getForObject("http://hello-servie/call", String.class);
        return json;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }
}
