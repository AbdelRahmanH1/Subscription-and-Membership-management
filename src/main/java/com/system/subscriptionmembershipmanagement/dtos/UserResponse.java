package com.system.subscriptionmembershipmanagement.dtos;

public record UserResponse (
        Long id,
        String name,
        String email,
        String role
){}