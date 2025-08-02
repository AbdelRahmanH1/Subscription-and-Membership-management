package com.system.subscriptionmembershipmanagement.mappers;

import com.system.subscriptionmembershipmanagement.dtos.CreateUserRequest;
import com.system.subscriptionmembershipmanagement.dtos.UserResponse;
import com.system.subscriptionmembershipmanagement.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserRequest request);
    UserResponse toDto(User user);
}
