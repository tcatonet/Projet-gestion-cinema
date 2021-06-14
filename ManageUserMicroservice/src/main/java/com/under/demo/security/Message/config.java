package com.under.demo.security.Message;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"Message","hello-world"})
@Configuration
public class config {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean
    public MessageReceiver receiver() {
        return new MessageReceiver();
    }

    @Profile("sender")
    @Bean
    public MessageSender sender() {
        return new MessageSender();
    }
}