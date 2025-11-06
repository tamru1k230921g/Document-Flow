package com.example.documentFlow.auth.endpoint;

import com.example.documentFlow.auth.dto.JwtAuthenticationResponse;
import com.example.documentFlow.auth.dto.SignInRequest;

public interface AuthEndpoint {

    JwtAuthenticationResponse signIn(SignInRequest request);

}
