package com.example.documentFlow.employee.mapper.impl;

import com.example.documentFlow.employee.dto.EmployeeDto;
import com.example.documentFlow.employee.dto.SignUpRequest;
import com.example.documentFlow.employee.mapper.EmployeeMapping;
import com.example.documentFlow.employee.model.Employee;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EmployeeMappingImpl implements EmployeeMapping {

    PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public Employee createUser(SignUpRequest request) {
        return Employee.builder()
                .username(request.getUsername().toLowerCase())
                .email(request.getEmail().toLowerCase())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDto toDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setUsername(employee.getUsername());
        dto.setEmail(employee.getEmail());
        dto.setRole(employee.getRole());
        return dto;
    }


}
