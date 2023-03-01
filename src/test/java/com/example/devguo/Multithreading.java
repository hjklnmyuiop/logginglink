package com.example.devguo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: dev_guo
 * @Date: 2023/2/21 9:38
 */
@SpringBootTest
public class Multithreading {
    @Test
    public static void main(String[] args)  throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(3);
        t.running = false; // 标志位置为false
    }
}
class HelloThread extends Thread {

    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}