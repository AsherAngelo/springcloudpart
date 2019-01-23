package com.cnpc;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by 赵梦杰 on 2018/5/29.
 */
public class HelloCommon extends HystrixCommand<String> {


    protected HelloCommon() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()//.withCircuitBreakerForceOpen(true)这是一个断路器
                        .withExecutionTimeoutInMilliseconds(20000)));
    }

    protected String run() throws Exception {
        String url = "http://localhost:8080/hello";
        HttpGet httpget = new HttpGet(url);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpResponse response = httpclient.execute(httpget);
        return EntityUtils.toString(response.getEntity());
    }

    @Override
    protected String getFallback() {
        return "调用错误";
    }
}
