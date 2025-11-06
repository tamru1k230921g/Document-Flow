package com.example.documentFlow.auth.service;

import com.example.documentFlow.auth.dto.JwtAuthenticationResponse;
import com.example.documentFlow.auth.dto.SignInRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse signIn(SignInRequest request);

}
