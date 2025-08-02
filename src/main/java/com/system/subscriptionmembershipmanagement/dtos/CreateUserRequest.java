package com.system.subscriptionmembershipmanagement.dtos;

public record CreateUserRequest (

        String name,
        String email,
        String password,
        String role
){}
