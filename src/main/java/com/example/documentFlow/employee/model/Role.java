package com.example.documentFlow.employee.model;

import java.util.Objects;

public enum Role {
    USER,
    ADMIN,
    HR,
    HEAD,
    ARCHIVIST;

    public static boolean getRoles(Role role) {
        return Objects.equals(role, HEAD) ||
                Objects.equals(role, HR) ||
                Objects.equals(role, ARCHIVIST);
    }
}