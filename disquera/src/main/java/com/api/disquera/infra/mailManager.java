package com.api.disquera.infra;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class mailManager {

    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public mailManager(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMessage(String email, String messageEmail){

        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            message.setSubject("Prueba");
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setText(messageEmail);
            helper.setFrom(sender);
            javaMailSender.send(message);
        }catch(MessagingException e){
            throw new RuntimeException(e);
        }
    }
}
