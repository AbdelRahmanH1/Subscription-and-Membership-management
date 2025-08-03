package com.system.subscriptionmembershipmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class SubscriptionStillActiveException extends ApiException{
    public SubscriptionStillActiveException() {
        super("You already have an active subscription.", HttpStatus.BAD_REQUEST);
    }
}
