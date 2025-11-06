package com.example.documentFlow.documentHistory.endpoint;

import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.documentHistory.dto.DocumentHistoryDto;
import com.example.documentFlow.documentHistory.model.DocumentHistory;

import java.util.List;

public interface DocumentHistoryEndpoint {

    DocumentHistory create(Document document);

    List<DocumentHistoryDto> getHistories(Long documentId);
}


