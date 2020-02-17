package com.ssk.haoke.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaCenter {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCenter.class,args);
    }
}
