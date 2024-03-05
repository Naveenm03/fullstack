package com.zenyoga.naveen.service;

import com.zenyoga.naveen.dto.request.LoginRequest;
import com.zenyoga.naveen.dto.request.RegisterRequest;
import com.zenyoga.naveen.dto.response.LoginResponse;
import com.zenyoga.naveen.dto.response.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}