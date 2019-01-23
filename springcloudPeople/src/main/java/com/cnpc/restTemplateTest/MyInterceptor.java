package com.cnpc.restTemplateTest;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by 赵梦杰 on 2018/5/27.
 */
public class MyInterceptor implements ClientHttpRequestInterceptor {

    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("===============  这是自定义拦截器");
        System.out.println("         旧的uri：" + httpRequest.getURI());

        HttpRequest newRequest = new MyRequest(httpRequest);
        System.out.println("         新的uri:" + newRequest.getURI());

        return clientHttpRequestExecution.execute(newRequest, bytes);
    }
}
