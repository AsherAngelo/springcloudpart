package com.cnpc.healthcheck;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by 赵梦杰 on 2018/5/22.
 */
@RestController
public class Police1 {

    public static Boolean str = true;

    @RequestMapping(value = "/hello1/{name}")
    public String hello(@PathVariable String name){
        return "hello,"+name;
    }
}
