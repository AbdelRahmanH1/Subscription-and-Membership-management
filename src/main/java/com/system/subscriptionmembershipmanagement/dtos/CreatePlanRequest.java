package com.system.subscriptionmembershipmanagement.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreatePlanRequest(

        @NotBlank(message = "Plan name is required")
        @Size(max = 100, message = "Plan name must be less than 100 characters")
        String name,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", message = "Price must be greater than 0")
        @Digits(integer = 10, fraction = 2, message = "Price must be a valid monetary amount")
        BigDecimal price,

        @NotNull(message = "duration is required")
        @Min(value = 30, message = "Duration must be at least 30 days")
        @Max(value = 365, message = "Duration must not exceed 365 days")
        Integer duration,

        @NotBlank(message = "Description is required")
        @Size(max = 500, message = "Description must be less than 500 characters")
        String description
) {
}
