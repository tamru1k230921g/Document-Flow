package com.example.documentFlow.documentHistory.service;

import com.example.documentFlow.documentHistory.model.DocumentHistory;

import java.util.List;

public interface DocumentHistoryService {

    DocumentHistory save(DocumentHistory document);

    List<DocumentHistory> getHistories(Long documentId);

}
