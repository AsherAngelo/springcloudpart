package com.cnpc.Interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Created by 赵梦杰 on 2018/5/28.
 */
public class MyInterceptor implements RequestInterceptor {
    public void apply(RequestTemplate template) {
        template.header("Content-Type", "application/json");
        System.out.println("这是自定义请求拦截器");
    }
}
