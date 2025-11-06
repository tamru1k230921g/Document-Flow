package com.example.documentFlow.document.endpoint;

import com.example.documentFlow.document.dto.DocumentDto;
import com.example.documentFlow.document.dto.RequestDocument;
import com.example.documentFlow.document.dto.RequestSendDocument;

import java.util.List;

public interface DocumentEndpoint {

    List<DocumentDto> getDocumentsForEmployee();

    List<DocumentDto> getArchiveDocuments();

    DocumentDto createDocument(RequestDocument request);

    DocumentDto updateDocument(Long documentId, RequestDocument request);

    DocumentDto archiveDocument(Long documentId);

    DocumentDto sendDocument(Long documetnId, RequestSendDocument employeeId);

    void checkChoose(Long documentId);
}


