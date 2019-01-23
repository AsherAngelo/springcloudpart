package com.cnpc.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * Created by 赵梦杰 on 2018/5/23.
 */

//健康指示器
@Component
public class MyHealthIndicator implements HealthIndicator {

    public Health health() {
        if(Police1.str){
            return new Health.Builder(Status.UP).build();
        }else{
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
