package com.cnpc.client;

import feign.Feign;

/**
 * Created by 赵梦杰 on 2018/5/28.
 */
public class ClientMain {
    public static void main(String[] args) {
        HttpClient client = Feign.builder()
                .contract(new MyContract())
                .target(HttpClient.class,
                        "http://localhost:8080");
        String result = client.hello();
        System.out.println(result);
    }
}
