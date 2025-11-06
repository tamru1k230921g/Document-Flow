package com.example.documentFlow.document.endpoint.impl;

import com.example.documentFlow.document.dto.DocumentDto;
import com.example.documentFlow.document.dto.RequestDocument;
import com.example.documentFlow.document.dto.RequestSendDocument;
import com.example.documentFlow.document.endpoint.DocumentEndpoint;
import com.example.documentFlow.document.mapper.DocumentMapping;
import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.document.model.Status;
import com.example.documentFlow.document.service.DocumentService;
import com.example.documentFlow.documentHistory.endpoint.DocumentHistoryEndpoint;
import com.example.documentFlow.employee.model.Employee;
import com.example.documentFlow.employee.service.EmployeeService;
import com.example.documentFlow.util.EmployeeProvider;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class DocumentEndpointImpl implements DocumentEndpoint {

    EmployeeProvider currentlyEmployee;
    DocumentService service;
    DocumentMapping mapping;
    EmployeeService employeeService;
    DocumentHistoryEndpoint historyEndpoint;

    @Override
    @Transactional(readOnly = true)
    public List<DocumentDto> getDocumentsForEmployee() {
        Long employeeId = currentlyEmployee.getCurrentUser().getId();
        List<Document> response = service.getAllDocumentsByOwner(employeeId, Status.ACTIVE);
        return mapping.toDtos(response);
    }

    @Override
    public List<DocumentDto> getArchiveDocuments() {
        Long employeeId = currentlyEmployee.getCurrentUser().getId();
        List<Document> response = service.getAllDocumentsByOwner(employeeId, Status.ARCHIVED);
        return mapping.toDtos(response);
    }

    @Override
    @Transactional
    public DocumentDto createDocument(RequestDocument request) {
        Document document = mapping.create(request,currentlyEmployee.getCurrentUser());
        service.save(document);
        historyEndpoint.create(document);
        return mapping.toDto(document);
    }

    @Override
    @Transactional
    public DocumentDto updateDocument(Long documentId,RequestDocument request) {
        Document document = service.getOwnerDocument(documentId, Status.ACTIVE);
        mapping.update(document, request);
        historyEndpoint.create(document);
        service.save(document);
        return mapping.toDto(document);
    }

    @Override
    @Transactional
    public DocumentDto archiveDocument(Long documentId) {
        Document document = service.getOwnerDocument(documentId, Status.ACTIVE);
        Long employeeId = currentlyEmployee.getCurrentUser().getId();
        mapping.archiveDocument(document,employeeId);
        historyEndpoint.create(document);
        service.save(document);
        return mapping.toDto(document) ;
    }

    @Override
    @Transactional
    public DocumentDto sendDocument(Long documentId, RequestSendDocument employeeId){
        Employee employee = employeeService.getOneEmployee(employeeId.getTargetEmployeeId());
        if( Objects.equals(employee, currentlyEmployee.getCurrentUser()) )
        {
            throw new RuntimeException("Вы не можете отправить самому себе!");
        }
        else
        {
            Document document = service.getOwnerDocument(documentId, Status.ACTIVE);
            mapping.sendDocument(document,employee);
            historyEndpoint.create(document);
            service.save(document);
            return mapping.toDto(document);
        }
    }

    @Override
    public void checkChoose(Long documentId) {
        Document document = service.getOneDocument(documentId, Status.ARCHIVED);
        mapping.unzipping(document);
        service.save(document);
        historyEndpoint.create(document);
    }
}
