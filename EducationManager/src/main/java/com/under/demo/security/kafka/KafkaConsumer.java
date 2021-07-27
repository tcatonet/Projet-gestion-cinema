package com.under.demo.security.kafka;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.under.demo.security.security.TokenProvider;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class KafkaConsumer {
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    private TokenProvider tokenProvider;
    private AuthenticationManagerBuilder authenticationManager;

    @KafkaListener(topics = "loginAPIEducationManager", id = "myid")
    public void listenGroupFoo(String message) {
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jsonObject.get("name"), jsonObject.get("password"));


    }
}
