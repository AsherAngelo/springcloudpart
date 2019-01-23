package com.cnpc.Feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 赵梦杰 on 2018/5/28.
 */
@FeignClient("cloud-police")
public interface HttpClient {

    @MyUrl(url = "/hello1", method = "GET")
    public String hello1();

    @RequestMapping(method = RequestMethod.GET, value="/hello")
    public String hello();
}
