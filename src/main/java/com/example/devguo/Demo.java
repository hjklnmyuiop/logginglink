package com.example.devguo;

/**
 * @Author: dev_guo
 * @Date: 2022/8/1 18:35
 */
public class Demo {
    public static void main(String[] args) {
        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        System.out.println("Max="+max+"字节\t"+(max/(double)1024/1024+"MB"));
        System.out.println("total="+max+"字节\t"+(total/(double)1024/1024+"MB"));

    }
}
