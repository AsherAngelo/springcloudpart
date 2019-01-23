package com.cnpc;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by 赵梦杰 on 2018/5/27.
 */
public class PersonMain {
    public static void main(String[] args) {
        HttpClient httpClient = Feign.builder().decoder(new GsonDecoder()).target(HttpClient.class,"http://localhost:8080");
        Person p = httpClient.person();
        System.out.println(p.getName());
        System.out.println(p.getMessage());
    }
}
