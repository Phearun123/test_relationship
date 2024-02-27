package com.example.test_relationship.service.auth;

import com.example.test_relationship.payload.auth.AuthRequest;
import com.example.test_relationship.payload.user.UserRequest;

public interface AuthService {

    Object login(AuthRequest payload) throws Throwable;

    void signup(UserRequest payload) throws Throwable;
}
