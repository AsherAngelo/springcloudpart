package com.cnpc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * Created by 赵梦杰 on 2018/5/22.
 */
@SpringBootApplication
@EnableEurekaClient
public class policeApp {
    public static void main(String[] args){
        //SpringApplication.run(serverApp.class,args);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        new SpringApplicationBuilder(policeApp.class).properties("server.port="+str).run(args);
    }
}
