package com.cnpc.client;

import com.cnpc.Person;
import feign.RequestLine;

/**
 * Created by 赵梦杰 on 2018/5/27.
 */
public interface HttpClient {

    @MyUrl(url = "/hello", method = "GET")
    public String hello();

}
