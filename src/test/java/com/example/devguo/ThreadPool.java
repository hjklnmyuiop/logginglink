package com.example.devguo;

import java.util.concurrent.*;

/**
 * @Author: dev_guo
 * @Date: 2023/2/22 14:16
 */

public class ThreadPool {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:
        es.shutdown();

        Integer.valueOf(100);
        int min = 4;
        int max = 10;
        ExecutorService es2 = new ThreadPoolExecutor(min, max,
                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    }
}
class Task implements Runnable {
    private final String name;
    public Task(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("end task " + name);
    }
}
