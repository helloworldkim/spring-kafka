package com.example.springkafka.controller;

import com.example.springkafka.MyMessage;
import com.example.springkafka.producer.KafkaProduceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    @Autowired
    private KafkaProduceService kafkaProduceService;
    @GetMapping("/publish1")
    public String publish1(String message) {

        kafkaProduceService.send(message);
        return "published a message :" + message;
    }

    @GetMapping("/publish2")
    public String publish2(String message) {

        kafkaProduceService.sendWithCallback(message);
        return "published a message with callback:" + message;
    }

    @GetMapping("/publish3")
    public String publish3(MyMessage message) {

        kafkaProduceService.sendJson(message);
        return "published a message with callback:" + message.getName() + ", " + message.getMessage();
    }
}
