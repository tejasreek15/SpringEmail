package com.springemail.dto;

import lombok.Data;

@Data
public class EmailDetails {

    private String toEmail;
    private String body;
    private String subject;
    private String attachment;
}
