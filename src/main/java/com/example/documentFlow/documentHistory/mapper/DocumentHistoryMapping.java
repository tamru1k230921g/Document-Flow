package com.example.documentFlow.documentHistory.mapper;

import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.documentHistory.dto.DocumentHistoryDto;
import com.example.documentFlow.documentHistory.model.DocumentHistory;

import java.util.List;

public interface DocumentHistoryMapping {

    DocumentHistory create(Document document);

    DocumentHistoryDto toDto(DocumentHistory document);

    List<DocumentHistoryDto> toDtos(List<DocumentHistory> document);
}
