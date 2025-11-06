package com.example.documentFlow.auth.controller;
import com.example.documentFlow.auth.dto.JwtAuthenticationResponse;
import com.example.documentFlow.auth.dto.SignInRequest;
import com.example.documentFlow.auth.endpoint.AuthEndpoint;
import com.example.documentFlow.util.Paths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Paths.AUTH)
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

    AuthEndpoint authEndpoint;

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(
            @RequestBody @Valid SignInRequest request) {
        return authEndpoint.signIn(request);
    }
}
