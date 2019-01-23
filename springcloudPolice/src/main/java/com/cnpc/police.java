package com.cnpc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by 赵梦杰 on 2018/5/22.
 */
@RestController
public class police {

    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello,"+name;
    }

    @RequestMapping(value = "/ribbon")
    public String ribbonTest(HttpServletRequest httpServletRequest){
        return httpServletRequest.getRequestURL().toString();
    }
}
