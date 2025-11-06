package com.example.documentFlow.requestArchivist.model;

import com.example.documentFlow.core.base.AuditedEntity;
import com.example.documentFlow.core.base.RemovalEntity;
import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.employee.model.Employee;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "request_archivist")
public class RequestArchivist extends AuditedEntity {

    @Column(name = "request_message")
    private String requestMessage;

    @Enumerated(EnumType.STRING)
    @Column(name = "request_status")
    private RequestStatus requestStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private Document document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Employee owner;

}
