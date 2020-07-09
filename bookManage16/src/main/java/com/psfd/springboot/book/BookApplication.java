package com.psfd.springboot.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class BookApplication {
    public static void main(String[] args) {

        System.out.println("dwa");
        SpringApplication.run(BookApplication.class, args);
    }

}
