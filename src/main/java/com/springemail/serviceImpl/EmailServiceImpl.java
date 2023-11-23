package com.springemail.serviceImpl;

import com.springemail.dto.EmailDetails;
import com.springemail.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

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

    @Override
    public String sendMailWithAttachment(EmailDetails emailDetails) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(emailDetails.getToEmail());
        mimeMessageHelper.setText(emailDetails.getBody());
        mimeMessageHelper.setSubject(emailDetails.getSubject());
        FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
        mimeMessageHelper.addAttachment(file.getFilename(), file);
        javaMailSender.send(mimeMessage);
        return "mail sent successfully!!!";
    }
}
