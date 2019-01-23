package com.cnpc;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;
/**
 * Created by 赵梦杰 on 2018/5/25.
 */
public class RestRibbonClient {
    public static void main(String[] args) throws Exception {
        ConfigurationManager.getConfigInstance().setProperty(
                "my-client.ribbon.listOfServers", "localhost:8080,localhost:8081");
        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        HttpRequest request = HttpRequest.newBuilder().uri("/hello").build();
        for(int i = 0; i < 10; i++) {
            HttpResponse response = client.executeWithLoadBalancer(request);
            String json = response.getEntity(String.class);
            System.out.println(json);
        }
    }
}
