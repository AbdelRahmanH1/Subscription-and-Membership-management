package com.system.subscriptionmembershipmanagement.dtos;

import java.math.BigDecimal;

public record PlanResponse(
        String id,
        String name,
        BigDecimal price,
        Integer duration,
        String description
) {
}
