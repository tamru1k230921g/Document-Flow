package com.example.documentFlow.documentHistory.service.impl;

import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.documentHistory.model.DocumentHistory;
import com.example.documentFlow.documentHistory.repository.DocumentHistoryRepository;
import com.example.documentFlow.documentHistory.service.DocumentHistoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class DocumentHistoryServiceImpl implements DocumentHistoryService {

    DocumentHistoryRepository repository;

    @Override
    @Transactional
    public DocumentHistory save(DocumentHistory document){
        return repository.save(document);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentHistory> getHistories(Long documentId) {
        return repository.findAllByDocumentId(documentId);
    }
}
