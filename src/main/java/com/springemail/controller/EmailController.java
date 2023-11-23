package com.springemail.controller;

import com.springemail.dto.EmailDetails;
import com.springemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendmail")
    public String sendMail(@RequestBody EmailDetails emailDetails){
        String response =  emailService.sendEmail(emailDetails);
        return response;
    }
}
