package com.system.subscriptionmembershipmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class PaymentFailedException extends ApiException{
    public PaymentFailedException() {
        super("Payment could not be processed.", HttpStatus.PAYMENT_REQUIRED);
    }
}
