package com.system.subscriptionmembershipmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExists extends ApiException{
    public EmailAlreadyExists() {
        super("Email already exists", HttpStatus.BAD_REQUEST);
    }
}
