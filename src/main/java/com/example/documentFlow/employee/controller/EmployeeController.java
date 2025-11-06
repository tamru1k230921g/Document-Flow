package com.example.documentFlow.employee.controller;

import com.example.documentFlow.employee.dto.EmployeeDto;
import com.example.documentFlow.employee.dto.SignUpRequest;
import com.example.documentFlow.employee.endpoint.EmployeeEndpoint;
import com.example.documentFlow.util.Paths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.USER)
@RequiredArgsConstructor
@Tag(name = "Регистрация")
@SecurityRequirement(name = "JWT")
public class EmployeeController {

    private final EmployeeEndpoint employeeEndpoint;

    @Operation(summary = "Регистрация пользователя (только ADMIN-(HEAD HR) и HR-(USER))")
    @PostMapping("/sign-up")
    public EmployeeDto signUp(@RequestBody @Valid SignUpRequest request) {
        return employeeEndpoint.signUp(request);
    }


}
