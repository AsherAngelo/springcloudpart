package com.cnpc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

/**
 * Created by 赵梦杰 on 2018/5/23.
 */
@SpringBootApplication
public class ribbonserverApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        new SpringApplicationBuilder(ribbonserverApp.class).properties("server.port="+str).run(args);
    }
}
