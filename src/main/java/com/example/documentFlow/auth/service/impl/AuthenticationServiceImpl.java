package com.example.documentFlow.auth.service.impl;

import com.example.documentFlow.auth.dto.JwtAuthenticationResponse;
import com.example.documentFlow.auth.dto.SignInRequest;
import com.example.documentFlow.auth.service.AuthenticationService;
import com.example.documentFlow.auth.service.JwtService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationServiceImpl implements AuthenticationService {

    JwtService jwtService;
    AuthenticationManager authenticationManager;
    UserDetailsService userDetailsService;

    public JwtAuthenticationResponse signIn(SignInRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername().toLowerCase(),
                request.getPassword()
        ));

        UserDetails user = userDetailsService
                .loadUserByUsername(request.getUsername().toLowerCase());

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

}
