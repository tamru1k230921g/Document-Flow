package com.example.documentFlow.employee.model;

import com.example.documentFlow.core.base.AuditedEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Builder
@Getter
@Setter
@Table(name = "employee")
public class Employee extends AuditedEntity implements UserDetails {

    @Column(name = "username", unique = true)
    private  String username;

    @Column(name = "password")
    private  String password;

    @Column(name = "email", unique = true)
    private  String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return Collections.singletonList(
                 (GrantedAuthority) () -> "ROLE_" + role.name()
         );
     }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
