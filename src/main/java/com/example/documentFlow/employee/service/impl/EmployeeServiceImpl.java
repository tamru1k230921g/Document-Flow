package com.example.documentFlow.employee.service.impl;

import com.example.documentFlow.employee.model.Employee;
import com.example.documentFlow.employee.repository.EmployeeRepository;
import com.example.documentFlow.employee.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository repository;

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getOneEmployee(Long employeeId) {
        return repository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Пользователь с id : " + employeeId + " не найден"));
    }
}
