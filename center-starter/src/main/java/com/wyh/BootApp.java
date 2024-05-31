package com.wyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "com.wyh.infrastructure.mapper")
public class BootApp {
    public static void main(String[] args) {
        System.out.println("......");
        SpringApplication.run(BootApp.class, args);
    }
}
