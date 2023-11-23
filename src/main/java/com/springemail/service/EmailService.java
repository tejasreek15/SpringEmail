package com.springemail.service;


import com.springemail.dto.EmailDetails;

public interface EmailService {

    String sendEmail(EmailDetails emailDetails);
}
