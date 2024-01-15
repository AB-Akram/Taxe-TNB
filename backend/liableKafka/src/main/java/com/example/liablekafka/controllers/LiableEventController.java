package com.example.liablekafka.controllers;

import com.example.liablekafka.entities.Liable;
import com.example.liablekafka.service.LiableDemandPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/producer-liable")
public class LiableEventController {

    @Autowired
    private LiableDemandPublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@RequestBody Liable liable, @PathVariable String message) {
        try {
            publisher.sendMessageToTopic(liable, message);
            return ResponseEntity.ok("message published successfully !!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}
