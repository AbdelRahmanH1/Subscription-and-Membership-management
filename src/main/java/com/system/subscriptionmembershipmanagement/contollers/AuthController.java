package com.system.subscriptionmembershipmanagement.contollers;

import com.system.subscriptionmembershipmanagement.dtos.CreateUserRequest;
import com.system.subscriptionmembershipmanagement.dtos.LoginRequest;
import com.system.subscriptionmembershipmanagement.services.AuthService;
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
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody CreateUserRequest request){
        var response = authService.register(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request){
        var response = authService.Login(request);
        return ResponseEntity.ok().body(response);
    }
}
