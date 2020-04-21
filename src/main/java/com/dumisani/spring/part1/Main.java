package com.dumisani.spring.part1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        UserServicesImpl users = new UserServicesImpl();
        SpringApplication.run(Main.class, args);
        System.out.println(users.addUser(1,"Dumisani","Ngobeni"));
        System.out.println(users.getUser(1));
        //System.out.println(users.removeUser(1));
    }
}
