package com.system.subscriptionmembershipmanagement.dtos;

import com.system.subscriptionmembershipmanagement.enums.SubscriptionStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SubscriptionResponse {
    private String planName;
    private LocalDate startDate;
    private LocalDate endDate;
    private SubscriptionStatus status;
    private PaymentResponse payment;
}
