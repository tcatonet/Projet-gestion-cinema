package com.under.demo.security.kafka;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.under.demo.security.user.UserService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class KafkaConsumer {
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    private final UserService userService;


    public KafkaConsumer(UserService userService) {

        this.userService = userService;
    }


    @KafkaListener(topics = "loginAPIManageUser", id = "myid")
    public void listenGroupFoo(String message) {
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();

        String name = jsonObject.get("name").getAsString().replace("\"", "");
        String email = jsonObject.get("email").getAsString().replace("\"", "");
        String password = jsonObject.get("password").getAsString().replace("\"", "");
        String response = userService.createUser(name,email, password);

    }
}
