package com.example.documentFlow.employee.dto;

import com.example.documentFlow.employee.model.Role;
import lombok.Data;

@Data
public class EmployeeDto {

    private String username;
    private String email;
    private Role role;
}
