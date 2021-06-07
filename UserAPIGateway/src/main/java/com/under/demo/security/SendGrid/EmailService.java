package com.under.demo.security.SendGrid;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    SendGridConfig sendGridConfig = new SendGridConfig();

    @Value("d-971789e9ad0e42d1aac1758f0470296")
    private String templateId;

    @Autowired
    SendGrid sendGrid = sendGridConfig.getSendGrid();


    public void sendEmail(String email){

        try{
            Mail mail = prepareMail(email);
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sendGrid.api(request);
            if(response != null){
                System.out.println("response from sendGrid : "+response);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Mail prepareMail(String email){
        Mail mail = new Mail();
        Email fromEmail = new Email();
        fromEmail.setEmail("catonethomas@yahoo.fr");
        Email to = new Email();
        to.setEmail(email);

        Personalization personalization = new Personalization();
        personalization.addTo(to);
        mail.setTemplateId(templateId);

        return mail;
    }
}
