package com.example.documentFlow.core.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;

@Getter
@Setter
@Audited
@EntityListeners({RemovalEntity.class})
@MappedSuperclass
public abstract class RemovalEntity extends AuditedEntity {

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private Long deletedBy;
}
