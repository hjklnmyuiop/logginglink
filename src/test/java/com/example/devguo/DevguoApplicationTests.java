package com.example.devguo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class DevguoApplicationTests {

    @Test
    void contextLoads() {
        int i=0;
        int j=0;
        System.out.println(i++);
        System.out.println(++j);
    }
    @Test
    public void array(){
        ArrayList list = new ArrayList();
        list.add(123);
        // 获取到Object，必须强制转型为String:
        Object o = list.get(0);
        System.out.println(0);
    }
    @Test
    public  void pairCon() {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }
    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }
}
