package com.example.documentFlow.employee.endpoint;

import com.example.documentFlow.employee.dto.EmployeeDto;
import com.example.documentFlow.employee.dto.SignUpRequest;

public interface EmployeeEndpoint {

    EmployeeDto signUp(SignUpRequest request);
}


