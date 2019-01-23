package com.cnpc.Feign;

import com.cnpc.peopleApp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import java.util.Scanner;

/**
 * Created by 赵梦杰 on 2018/5/28.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class feignApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        new SpringApplicationBuilder(peopleApp.class).properties("server.port="+str).run(args);
    }
}
