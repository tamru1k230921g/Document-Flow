package com.example.documentFlow.core.base;

import com.example.documentFlow.config.audit.impl.AppRevisionListener;
import com.example.documentFlow.employee.model.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "revinfo", schema = "aud")
@RevisionEntity(AppRevisionListener.class)
public class RevEntity {

    @Id
    @RevisionNumber
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rev;

    @RevisionTimestamp
    @Column(name = "revtstmp")
    private long timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditor_id")
    private Employee auditor;
}

