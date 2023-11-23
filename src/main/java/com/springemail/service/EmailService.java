package com.springemail.service;


import com.springemail.dto.EmailDetails;
import jakarta.mail.MessagingException;

public interface EmailService {

    String sendEmail(EmailDetails emailDetails);

    String sendMailWithAttachment(EmailDetails emailDetails) throws MessagingException;
}
