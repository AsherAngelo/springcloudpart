package com.cnpc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 赵梦杰 on 2018/5/25.
 */
@RestController
public class HelloWrold {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public String person(HttpServletRequest httpServletRequest){
        return httpServletRequest.getRequestURL().toString();
    }
}
