package com.system.subscriptionmembershipmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class PlanNotFound extends ApiException{
    public PlanNotFound() {
        super("Plan not found", HttpStatus.NOT_FOUND);
    }
}
