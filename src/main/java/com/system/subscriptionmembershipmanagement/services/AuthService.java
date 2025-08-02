package com.system.subscriptionmembershipmanagement.services;

import com.system.subscriptionmembershipmanagement.dtos.CreateUserRequest;
import com.system.subscriptionmembershipmanagement.dtos.JwtResponse;
import com.system.subscriptionmembershipmanagement.dtos.LoginRequest;
import com.system.subscriptionmembershipmanagement.dtos.UserResponse;
import com.system.subscriptionmembershipmanagement.enums.UserRole;
import com.system.subscriptionmembershipmanagement.exceptions.EmailAlreadyExists;
import com.system.subscriptionmembershipmanagement.mappers.UserMapper;
import com.system.subscriptionmembershipmanagement.repositories.UserRepository;
import com.system.subscriptionmembershipmanagement.security.CustomUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserResponse register(CreateUserRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExists();
        }
        var user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        if (user.getRole() == null) {
            user.setRole(UserRole.USER);
        }
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public JwtResponse Login(LoginRequest request) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        var user = (CustomUserDetails) authentication.getPrincipal();
        var token = jwtService.generateToken(user);
        return new JwtResponse(token);
    }


}
