package com.example.documentFlow.util;

import com.example.documentFlow.employee.model.Employee;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProvider {

    public Employee getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof Employee employee)
            return employee;

        throw new IllegalStateException("Пользователь не является Employee");
    }

}

