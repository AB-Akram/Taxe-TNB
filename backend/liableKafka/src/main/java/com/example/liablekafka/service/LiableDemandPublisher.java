package com.example.liablekafka.service;

import com.example.liablekafka.entities.Liable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class LiableDemandPublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(Liable liable, String message) {
        CompletableFuture<SendResult<String, Object>> topicLiable = template
                .send("topicLiable", message + " CIN : " + liable.getCin());
        topicLiable.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println(message + " CIN : " + liable.getCin());
            } else {
                System.out.println("Unable to sent message = [ " + message + "] due to " + ex.getMessage());
            }
        });
    }
}
