package com.example.documentFlow.employee.endpoint.impl;

import com.example.documentFlow.employee.dto.EmployeeDto;
import com.example.documentFlow.employee.dto.SignUpRequest;
import com.example.documentFlow.employee.endpoint.EmployeeEndpoint;
import com.example.documentFlow.employee.mapper.EmployeeMapping;
import com.example.documentFlow.employee.model.Employee;
import com.example.documentFlow.employee.model.Role;
import com.example.documentFlow.employee.service.EmployeeService;
import com.example.documentFlow.util.EmployeeProvider;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EmployeeEndpointImpl implements EmployeeEndpoint {

    EmployeeService service;
    EmployeeMapping mapping;
    EmployeeProvider currentlyEmployee;

    @Override
    @Transactional
    public EmployeeDto signUp(SignUpRequest request) {
        validate(request);
        Employee employee = mapping.createUser(request);
        service.save(employee);
        return mapping.toDto(employee);
    }

    private void validate(SignUpRequest request) {
        Role currentlyRole = currentlyEmployee.getCurrentUser().getRole();
        Role newEmployeeRole = request.getRole();

        if (!(currentlyRole==Role.ADMIN && Role.getRoles(newEmployeeRole) || currentlyRole==Role.HR && newEmployeeRole== Role.USER)) {
            throw new RuntimeException("У Вас нет соответствующих прав");
        }
    }
}