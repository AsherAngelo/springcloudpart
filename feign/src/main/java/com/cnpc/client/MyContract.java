package com.cnpc.client;

import feign.Contract;
import feign.MethodMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by 赵梦杰 on 2018/5/28.
 */
public class MyContract extends Contract.BaseContract {

    protected void processAnnotationOnClass(MethodMetadata methodMetadata, Class<?> aClass) {

    }

    protected void processAnnotationOnMethod(MethodMetadata methodMetadata, Annotation annotation, Method method) {
        // 注解是MyUrl类型的，才处理
        if(MyUrl.class.isInstance(annotation)) {
            MyUrl myUrl = method.getAnnotation(MyUrl.class);
            String url = myUrl.url();
            String httpMethod = myUrl.method();
            methodMetadata.template().method(httpMethod);
            methodMetadata.template().append(url);
        }
    }

    protected boolean processAnnotationsOnParameter(MethodMetadata methodMetadata, Annotation[] annotations, int i) {
        return false;
    }
}
