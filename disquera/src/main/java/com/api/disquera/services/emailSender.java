package com.api.disquera.services;

import com.api.disquera.infra.mailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class emailSender {
    @Autowired
    mailManager mailManagerDep;

    public void sendMessage(String email, String message){
        mailManagerDep.sendMessage(email, message);
    }
}
