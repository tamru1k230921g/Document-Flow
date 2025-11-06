package com.example.documentFlow.employee.service;

import com.example.documentFlow.employee.model.Employee;


public interface EmployeeService {

    Employee save(Employee employee);

    Employee getOneEmployee(Long employeeId);
}
