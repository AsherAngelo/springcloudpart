package com.cnpc;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;

/**
 * Created by 赵梦杰 on 2018/5/25.
 */
public class HttpClientTest {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for(int i=0;i<10;i++){
            HttpGet httpGet = new HttpGet("http://localhost:8080/hello");
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(httpEntity));
        }
    }


}
