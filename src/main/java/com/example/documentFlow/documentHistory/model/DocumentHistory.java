package com.example.documentFlow.documentHistory.model;

import com.example.documentFlow.core.base.AuditedEntity;
import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.document.model.DocumentAction;
import com.example.documentFlow.document.model.Status;
import com.example.documentFlow.employee.model.Employee;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "document_history")
public class DocumentHistory extends AuditedEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "document_action")
    private DocumentAction documentAction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private Document document;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Employee owner;
}
