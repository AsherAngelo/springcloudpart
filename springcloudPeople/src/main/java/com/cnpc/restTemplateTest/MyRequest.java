package com.cnpc.restTemplateTest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;

/**
 * Created by 赵梦杰 on 2018/5/27.
 */
public class MyRequest implements HttpRequest {
    HttpRequest sourceRequest;

    public MyRequest(HttpRequest sourceRequest) {
        this.sourceRequest = sourceRequest;
    }

    public HttpHeaders getHeaders() {
        return sourceRequest.getHeaders();
    }

    public HttpMethod getMethod() {
        return sourceRequest.getMethod();
    }

    public URI getURI() {
        try {
            URI newUri = new URI("http://localhost:8080/hello");
            return newUri;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceRequest.getURI();
    }

}
