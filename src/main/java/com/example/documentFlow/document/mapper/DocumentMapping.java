package com.example.documentFlow.document.mapper;

import com.example.documentFlow.document.dto.DocumentDto;
import com.example.documentFlow.document.dto.RequestDocument;
import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.employee.model.Employee;

import java.util.List;

public interface DocumentMapping {

    DocumentDto toDto(Document entity);

    List<DocumentDto> toDtos(List<Document> entity);

    Document create(RequestDocument dto, Employee employee);

    void update(Document document, RequestDocument dto);

    void archiveDocument(Document document, Long employeeId);

    void sendDocument(Document document, Employee employee);

    void unzipping(Document document);
}
