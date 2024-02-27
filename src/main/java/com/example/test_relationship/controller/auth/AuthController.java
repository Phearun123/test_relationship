package com.example.test_relationship.controller.auth;

import com.example.test_relationship.controller.TRelationshipRestController;
import com.example.test_relationship.payload.auth.AuthRequest;
import com.example.test_relationship.payload.user.UserRequest;
import com.example.test_relationship.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController extends TRelationshipRestController {

    private final AuthService authService;

    @PostMapping("/signup")
    public Object signup(@RequestBody @Valid UserRequest payload) throws Throwable {
        authService.signup(payload);
        return ok();
    }


    @PostMapping("/login")
    public Object login(@RequestBody @Valid AuthRequest payload) throws Throwable{
        return ok(authService.login(payload));
    }

}
