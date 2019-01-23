package com.cnpc.log;

import com.cnpc.HttpClient;
import feign.Feign;
import feign.Logger;

/**
 * Created by 赵梦杰 on 2018/5/28.
 */
public class LogMain {
    public static void main(String[] args) {
        /**
         * NONE：默认值，不记录日志
         * BASIC：记录请求方法、URL、响应状态代码和执行时间
         * HEADERS：除BASIC记录的日志外，还会记录请求头和响应头的信息
         * FULLL：在HEADERS的基础上，请求和响应的元数据，都会保存
         */
        HttpClient client = Feign.builder()
                .logLevel(Logger.Level.FULL)
                .logger(new Logger.JavaLogger().appendToFile("logs/http.log"))
                .target(HttpClient.class,
                        "http://localhost:8080");
        String result = client.hello();
        System.out.println(result);
    }
}
