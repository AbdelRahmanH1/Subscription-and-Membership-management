package com.system.subscriptionmembershipmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends ApiException{
    public DuplicateResourceException() {
        super("Plan with this name already exists", HttpStatus.BAD_REQUEST);
    }
}
