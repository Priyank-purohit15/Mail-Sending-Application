package com.email.email.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.email.Model.EmailRequest;
import com.email.email.service.emailService;

@RestController
public class EmailController {
    
    @Autowired
    private emailService emailService;

    @GetMapping("/welcome")
    public String wolcome() {
        return "This is my email APi";
    }

    @PostMapping("/sendmail")
    public ResponseEntity<?> sendMail(@RequestBody EmailRequest request) {
        System.out.println(request);
        this.emailService.sendEmail(request.getSubject() , request.getMessage() , request.getTo());
        return ResponseEntity.ok("Done");
    }
}
