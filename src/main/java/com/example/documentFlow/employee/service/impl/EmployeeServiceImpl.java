package com.example.documentFlow.employee.service.impl;

import com.example.documentFlow.auth.service.JwtService;
import com.example.documentFlow.employee.model.Employee;
import com.example.documentFlow.employee.repository.EmployeeRepository;
import com.example.documentFlow.employee.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EmployeeServiceImpl implements EmployeeService {

    JwtService jwtService;

    EmployeeRepository repository;


    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Employee getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }

    @Override
    public Employee getOneEmployee(Long employeeId) {
        return repository.findById(employeeId)
                .orElseThrow(()-> new RuntimeException("Пользователь с id : " + employeeId + " не найден"));
    }
}
