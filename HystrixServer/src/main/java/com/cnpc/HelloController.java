package com.cnpc;

import com.cnpc.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 赵梦杰 on 2018/5/29.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello,world";
    }

    @RequestMapping("/person")
    public Person person(HttpServletRequest httpServletRequest){
        Person p = new Person();
        p.setName("123");
        p.setMessage(httpServletRequest.getRequestURL().toString());
        return p;
    }
}
