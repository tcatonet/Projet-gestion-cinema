package com.under.demo.security.SendGrid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sendgrid.SendGrid;


@Configuration
public class SendGridConfig {

    @Value("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")
    private String appKey;

    @Bean
    public SendGrid getSendGrid(){
        return new SendGrid(appKey);
    }
}
