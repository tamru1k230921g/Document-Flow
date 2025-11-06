package com.example.documentFlow.employee.mapper;

import com.example.documentFlow.employee.dto.EmployeeDto;
import com.example.documentFlow.employee.dto.SignUpRequest;
import com.example.documentFlow.employee.model.Employee;

public interface EmployeeMapping {

    Employee createUser(SignUpRequest request);

    EmployeeDto toDto(Employee employee);
}
