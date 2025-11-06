package com.example.documentFlow.auth.endpoint.impl;

import com.example.documentFlow.auth.dto.JwtAuthenticationResponse;
import com.example.documentFlow.auth.dto.SignInRequest;
import com.example.documentFlow.auth.endpoint.AuthEndpoint;
import com.example.documentFlow.auth.service.impl.AuthenticationServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthEndpointImpl implements AuthEndpoint {

    AuthenticationServiceImpl authenticationService;

    public JwtAuthenticationResponse signIn(
            SignInRequest request) {
        return authenticationService.signIn(request);
    }

}
