package com.api.disquera.controllers;

import com.api.disquera.services.emailSender;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    emailSender emailSenderDep;

    @Operation(summary = "Mandar un correo")
    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody Map<String, String> data){
        emailSenderDep.sendMessage(data.get("email"), data.get("message"));
        return ResponseEntity.ok().body("Ok");
    }
}
