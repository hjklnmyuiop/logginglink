package com.example.devguo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DevguoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevguoApplication.class, args);
    }

}
