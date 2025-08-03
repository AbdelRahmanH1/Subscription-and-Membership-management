package com.system.subscriptionmembershipmanagement.contollers;

import com.system.subscriptionmembershipmanagement.dtos.CreateUserRequest;
import com.system.subscriptionmembershipmanagement.dtos.LoginRequest;
import com.system.subscriptionmembershipmanagement.services.AuthService;
import com.system.subscriptionmembershipmanagement.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Tag(name = "Authentication", description = "Public login endpoint for users")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @Operation(
            summary = "Register a new user",
            description = "Creates a new user account with the provided details."
    )
    public ResponseEntity<?> register(@Valid @RequestBody CreateUserRequest request){
        var response = authService.register(request);
        return ResponseUtil.success("User registered successfully", response);
    }

    @PostMapping("/login")
    @Operation(
            summary = "Login and get JWT token",
            description = "Authenticate a user with email and password. Returns a JWT token if successful."
    )
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request){
        var response = authService.Login(request);
        return ResponseUtil.success("Login successfully", response);
    }
}
