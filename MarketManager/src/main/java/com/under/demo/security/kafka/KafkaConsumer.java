package com.under.demo.security.kafka;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.under.demo.security.security.TokenProvider;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class KafkaConsumer {
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManager;

    public KafkaConsumer(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManager) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @KafkaListener(topics = "loginAPIMarketManager", id = "myid")
    public void listenGroupFoo(String message) {
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();

        String name = jsonObject.get("name").getAsString();
        name =name.replace("\"","");
        String password = jsonObject.get("password").getAsString();
        password =password.replace("\"","");
        LOGGER.info("name: " + name);
        LOGGER.info("password: " + password);



    }
}
