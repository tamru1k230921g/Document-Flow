package com.example.documentFlow.document.service;

import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.document.model.Status;

import java.util.List;

public interface DocumentService {

    Document save(Document documentId);

    Document getOneDocument(Long documentId, Status documentStatus);

    Document getOwnerDocument(Long documentId, Status documentStatus);

    List<Document> getAllDocumentsByOwner(Long employeeId, Status statusDocument);
}
