package com.cnpc.healthcheck;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * Created by 赵梦杰 on 2018/5/23.
 */

//健康检查处理器
@Component
public class MyHealthCheckHandler implements HealthCheckHandler{

    @Autowired
    private MyHealthIndicator myHealthIndicator;

    public InstanceStatus getStatus(InstanceStatus instanceStatus) {
        Status status = myHealthIndicator.health().getStatus();
        if(status.equals(Status.DOWN)){
            return InstanceStatus.DOWN;
        }else{
            return InstanceStatus.UP;
        }
    }
}
