package com.cnpc;

/**
 * Created by 赵梦杰 on 2018/5/29.
 */
public class HystrixMain {
    public static void main(String[] args){
        HelloCommon helloCommon = new HelloCommon();
        System.out.println(helloCommon.execute());
    }
}
