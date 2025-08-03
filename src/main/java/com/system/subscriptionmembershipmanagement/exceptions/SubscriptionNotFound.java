package com.system.subscriptionmembershipmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class SubscriptionNotFound extends ApiException{
    public SubscriptionNotFound() {
        super("You don't have an active subscription", HttpStatus.BAD_REQUEST);
    }
}
