package com.example.liablekafkaconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LiableKafkaConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiableKafkaConsumeApplication.class, args);
    }

}
