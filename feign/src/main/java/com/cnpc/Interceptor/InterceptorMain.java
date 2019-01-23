package com.cnpc.Interceptor;

import com.cnpc.HttpClient;
import feign.Feign;
import feign.Logger;

/**
 * Created by 赵梦杰 on 2018/5/28.
 */
public class InterceptorMain {
    public static void main(String[] args) {
        HttpClient client = Feign.builder()
                .requestInterceptor(new MyInterceptor())
                .target(HttpClient.class,
                        "http://localhost:8080");
        String result = client.hello();
        System.out.println(result);
    }
}
