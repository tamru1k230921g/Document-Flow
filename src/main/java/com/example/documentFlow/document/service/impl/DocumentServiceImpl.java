package com.example.documentFlow.document.service.impl;

import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.document.model.Status;
import com.example.documentFlow.document.repository.DocumentRepository;
import com.example.documentFlow.document.service.DocumentService;
import com.example.documentFlow.util.EmployeeProvider;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DocumentServiceImpl implements DocumentService {

    DocumentRepository repository;
    EmployeeProvider currentlyEmployee;

    @Override
    @Transactional
    public Document save(Document document) {
        return repository.save(document);
    }

    @Override
    @Transactional(readOnly = true)
    public Document getOwnerDocument(Long documentId, Status documentStatus) {
        Long employeeId = currentlyEmployee.getCurrentUser().getId();
        return repository.findOneByIdAndOwnerIdAndStatus(documentId, employeeId, documentStatus)
                .orElseThrow(() ->
                        new RuntimeException("Документ с id: " + documentId + " не найден или не доступен"));
    }

    @Override
    @Transactional(readOnly = true)
    public Document getOneDocument(Long documentId, Status documentStatus) {
        return repository.findOneByIdAndStatus(documentId, documentStatus)
                .orElseThrow(() ->
                        new RuntimeException("Документ с id: " + documentId + " не найден или не доступен"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Document> getAllDocumentsByOwner(Long employeeId, Status statusDocument) {
        return repository.findAllDocumentByOwnerIdAndStatus(employeeId, statusDocument)
                .orElseThrow(() ->
                        new RuntimeException("Документы пользователя с  id: " + employeeId + " не найдены или не доступны"));
    }
}
