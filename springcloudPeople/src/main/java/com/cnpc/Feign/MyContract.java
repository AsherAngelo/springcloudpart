package com.cnpc.Feign;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import feign.MethodMetadata;

/**
 * Created by 赵梦杰 on 2018/5/28.
 */
public class MyContract extends SpringMvcContract{

    @Override
    protected void processAnnotationOnMethod(MethodMetadata data, Annotation methodAnnotation, Method method) {
        super.processAnnotationOnMethod(data, methodAnnotation, method);
        if(MyUrl.class.isInstance(methodAnnotation)) {
            System.out.println("#############  这是自定义翻译器");
            MyUrl myUrl = method.getAnnotation(MyUrl.class);
            String url = myUrl.url();
            String httpMethod = myUrl.method();
            data.template().method(httpMethod);
            data.template().append(url);
        }


    }
}
