package com.cnpc;

import feign.RequestLine;

/**
 * Created by 赵梦杰 on 2018/5/27.
 */
public interface HttpClient {

    @RequestLine("GET /hello")
    public String hello();

    @RequestLine("GET /person")
    public Person person();
}
