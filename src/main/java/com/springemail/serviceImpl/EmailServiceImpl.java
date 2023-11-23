package com.springemail.serviceImpl;

import com.springemail.dto.EmailDetails;
import com.springemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendEmail(EmailDetails emailDetails){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(emailDetails.getToEmail());
        simpleMailMessage.setText(emailDetails.getBody());
        simpleMailMessage.setSubject(emailDetails.getSubject());
        javaMailSender.send(simpleMailMessage);
        return "mail sent successfully!!!";
    }
}
