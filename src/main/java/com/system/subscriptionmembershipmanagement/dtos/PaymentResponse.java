package com.system.subscriptionmembershipmanagement.dtos;

import com.system.subscriptionmembershipmanagement.enums.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentResponse {
    private BigDecimal amount;
    private PaymentStatus status;
}
