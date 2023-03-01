package com.example.devguo;

import java.util.ArrayList;

/**
 * @Author: dev_guo
 * @Date: 2022/8/2 9:46
 */
public class Demo3 {
    public static void main(String[] args) {
        byte[] array = new byte[1*1024*1024];
        ArrayList<Demo3> list = new ArrayList<>();
        int count = 0;
        try {
            while (true){
                list.add(new Demo3());
                count=count+1;
                System.out.println("count:"+count);
            }
        }catch (Error error){
            System.out.println("count:"+count);
            error.printStackTrace();
        }

    }
}
