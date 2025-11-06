package com.example.documentFlow.config.audit.impl;

import com.example.documentFlow.core.base.RevEntity;
import com.example.documentFlow.employee.model.Employee;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;

public class AppRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        if (SecurityContextHolder.getContext() == null ||
                SecurityContextHolder.getContext().getAuthentication() == null ||
                SecurityContextHolder.getContext().getAuthentication().getPrincipal() == null ||
                !(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof Employee user)) {
            return;
        }

        RevEntity revision = (RevEntity) revisionEntity;

        revision.setAuditor(user);
    }
}
