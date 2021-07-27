package com.under.demo.security.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.logging.Logger;

public class KafkaConsumer {
    private static final Logger LOGGER = Logger.getLogger("LOG: ");

    @KafkaListener(topics = "topicName", groupId = "myid")
    public void listenGroupFoo(String message) {

         LOGGER.info("Received Message in group myid: " + message);

    }
}
