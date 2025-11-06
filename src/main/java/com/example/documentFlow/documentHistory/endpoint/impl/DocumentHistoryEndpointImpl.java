package com.example.documentFlow.documentHistory.endpoint.impl;

import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.documentHistory.dto.DocumentHistoryDto;
import com.example.documentFlow.documentHistory.endpoint.DocumentHistoryEndpoint;
import com.example.documentFlow.documentHistory.mapper.DocumentHistoryMapping;
import com.example.documentFlow.documentHistory.model.DocumentHistory;
import com.example.documentFlow.documentHistory.service.DocumentHistoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DocumentHistoryEndpointImpl implements DocumentHistoryEndpoint {

    DocumentHistoryMapping mapping;
    DocumentHistoryService service;

    @Override
    @Transactional
    public DocumentHistory create(Document document) {
        DocumentHistory documentHistory = mapping.create(document);
        return service.save(documentHistory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentHistoryDto> getHistories(Long documentId) {
        List<DocumentHistory> document = service.getHistories(documentId);
        return mapping.toDtos(document);
    }
}
