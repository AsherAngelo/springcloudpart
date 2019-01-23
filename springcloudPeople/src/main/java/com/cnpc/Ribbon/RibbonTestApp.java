package com.cnpc.Ribbon;

import com.cnpc.peopleApp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import java.util.Scanner;

/**
 * Created by 赵梦杰 on 2018/5/25.
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonTestApp {
    public static void main(String[] args){
        //SpringApplication.run(serverApp.class,args);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        new SpringApplicationBuilder(peopleApp.class).properties("server.port="+str).run(args);
    }
}
