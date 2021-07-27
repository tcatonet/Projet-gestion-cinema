package com.under.demo.security.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaSender {

    private static final Logger LOGGER = Logger.getLogger("LOG: ");

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageManageUser(String msg) {
        LOGGER.info("message send");
        kafkaTemplate.send("loginAPIManageUser", msg);
    }

    public void sendMessageEducationManager(String msg) {
        LOGGER.info("message send");
        kafkaTemplate.send("loginAPIEducationManager", msg);
    }

    public void sendMessageMarketManager(String msg) {
        LOGGER.info("message send");
        kafkaTemplate.send("loginAPIMarketManager", msg);
    }
}
