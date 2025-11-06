package com.example.documentFlow.config.audit;

import com.example.documentFlow.config.audit.impl.ApplicationAuditAware;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuditConfig {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new ApplicationAuditAware();
    }
}
