package com.example.slave.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaHandler {
    @KafkaListener(topics = {"mykafka"})
    public void listenT1(String name) throws Exception {
        System.out.println(name);
    }

}
