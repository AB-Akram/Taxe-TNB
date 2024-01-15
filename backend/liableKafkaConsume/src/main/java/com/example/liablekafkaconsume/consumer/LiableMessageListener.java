package com.example.liablekafkaconsume.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LiableMessageListener {

    Logger log = LoggerFactory.getLogger(LiableMessageListener.class);

    @KafkaListener(topics = "topicLiable", groupId = "liable-group-1")
    public void consume(String message) {
        log.info("Liable send the message : " + message);
    }
}
