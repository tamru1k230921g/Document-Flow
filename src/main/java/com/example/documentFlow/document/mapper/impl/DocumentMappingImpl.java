package com.example.documentFlow.document.mapper.impl;

import com.example.documentFlow.document.dto.DocumentDto;
import com.example.documentFlow.document.dto.RequestDocument;
import com.example.documentFlow.document.mapper.DocumentMapping;
import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.document.model.DocumentAction;
import com.example.documentFlow.document.model.Status;
import com.example.documentFlow.employee.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentMappingImpl implements DocumentMapping {

    @Override
    @Transactional(readOnly = true)
    public DocumentDto toDto(Document entity) {
        DocumentDto dto = new DocumentDto();
        dto.setDocumentName(entity.getDocumentName());
        dto.setDescription(entity.getDescription());
        dto.setFilePath(entity.getFilePath());
        dto.setDocumentAction(entity.getDocumentAction());
        dto.setStatus(entity.getStatus());
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentDto> toDtos(List<Document> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Document create(RequestDocument dto, Employee employee) {
        Document document = new Document();
        document.setDescription(dto.getDescription());
        document.setDocumentName(dto.getDocumentName());
        document.setFilePath(dto.getFilePath());
        document.setDocumentAction(DocumentAction.CREATE);
        document.setStatus(Status.ACTIVE);
        document.setOwner(employee);
        return document;
    }

    @Override
    @Transactional(readOnly = true)
    public void update(Document document, RequestDocument dto) {
        document.setDescription(dto.getDescription());
        document.setDocumentName(dto.getDocumentName());
        document.setFilePath(dto.getFilePath());
        document.setDocumentAction(DocumentAction.UPDATE);
    }

    @Override
    @Transactional(readOnly = true)
    public void archiveDocument(Document document, Long employeeId) {
        document.setStatus(Status.ARCHIVED);
        document.setDeletedAt(LocalDateTime.now());
        document.setDeletedBy(employeeId);
        document.setDocumentAction(DocumentAction.DELETE);
    }

    @Override
    @Transactional(readOnly = true)
    public void sendDocument(Document document, Employee employee) {
        document.setOwner(employee);
        document.setDocumentAction(DocumentAction.SEND);
    }

    @Override
    @Transactional(readOnly = true)
    public void unzipping(Document document) {
        document.setStatus(Status.ACTIVE);
        document.setDocumentAction(DocumentAction.UNZIPPING);
    }
}
