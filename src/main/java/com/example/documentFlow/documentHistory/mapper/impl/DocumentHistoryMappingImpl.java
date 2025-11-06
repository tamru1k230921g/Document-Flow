package com.example.documentFlow.documentHistory.mapper.impl;

import com.example.documentFlow.document.dto.DocumentDto;
import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.documentHistory.dto.DocumentHistoryDto;
import com.example.documentFlow.documentHistory.mapper.DocumentHistoryMapping;
import com.example.documentFlow.documentHistory.model.DocumentHistory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentHistoryMappingImpl implements DocumentHistoryMapping {

    @Override
    @Transactional
    public DocumentHistory create(Document document) {
        DocumentHistory documentHistory = new DocumentHistory();
        documentHistory.setOwner(document.getOwner());
        documentHistory.setDocumentName(document.getDocumentName());
        documentHistory.setDocumentAction(document.getDocumentAction());
        documentHistory.setDescription(document.getDescription());
        documentHistory.setFilePath(document.getFilePath());
        documentHistory.setStatus(document.getStatus());
        documentHistory.setCreatedBy(document.getCreatedBy());
        documentHistory.setCreatedBy(documentHistory.getCreatedBy());
        documentHistory.setOwner(document.getOwner());
        documentHistory.setDocument(document);
        return documentHistory;
    }

    @Override
    public DocumentHistoryDto toDto(DocumentHistory document) {
        DocumentHistoryDto dto = new DocumentHistoryDto();
        dto.setDocumentId(document.getId());
        dto.setDocumentName(document.getDocumentName());
        dto.setDescription(document.getDescription());
        dto.setFilePath(document.getFilePath());
        dto.setDocumentAction(document.getDocumentAction());
        dto.setOwnerId(document.getOwner().getId());
        dto.setStatus(document.getStatus());
        return dto;
    }

    @Override
    public List<DocumentHistoryDto> toDtos(List<DocumentHistory> document) {
        return document.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
