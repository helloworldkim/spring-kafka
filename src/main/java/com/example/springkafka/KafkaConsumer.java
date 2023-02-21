package com.example.springkafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final String TOPIC_NAME = "topic5";
    private static final String GROUP_ID = "group_one";

    ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = TOPIC_NAME)
    public void listenMessage(String jsonMessage) {

        try {
            MyMessage message = mapper.readValue(jsonMessage, MyMessage.class);
            System.out.println("listenMessage = " + message.getName() +"," +message.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
