package com.sylvanas.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SylvanasUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SylvanasUserApplication.class, args);
    }

}
