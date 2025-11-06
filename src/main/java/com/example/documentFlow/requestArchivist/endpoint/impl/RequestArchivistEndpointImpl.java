package com.example.documentFlow.requestArchivist.endpoint.impl;

import com.example.documentFlow.document.endpoint.DocumentEndpoint;
import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.document.model.Status;
import com.example.documentFlow.document.service.DocumentService;
import com.example.documentFlow.requestArchivist.dto.RequestArchivistDto;
import com.example.documentFlow.requestArchivist.dto.RequestSendDto;
import com.example.documentFlow.requestArchivist.dto.RequestUpdateDto;
import com.example.documentFlow.requestArchivist.endpoint.RequestArchivistEndpoint;
import com.example.documentFlow.requestArchivist.mapper.RequestArchivistMapping;
import com.example.documentFlow.requestArchivist.model.RequestArchivist;
import com.example.documentFlow.requestArchivist.model.RequestStatus;
import com.example.documentFlow.requestArchivist.service.RequestArchivistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class RequestArchivistEndpointImpl implements RequestArchivistEndpoint {

    RequestArchivistService service;
    RequestArchivistMapping mapping;
    DocumentService documentService;
    DocumentEndpoint documentEndpoint;

    @Override
    @Transactional
    public RequestArchivistDto createRequest(Long documentId, RequestSendDto requestDto) {
        Document document = documentService.getOneDocument(documentId, Status.ARCHIVED);
        RequestArchivist request = mapping.createRequest(document, requestDto);
        service.save(request);
        return mapping.toDto(request);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestArchivistDto> getRequests() {
        List<RequestArchivist> request =  service.getRequests();
        return mapping.toDtos(request);
    }

    @Override
    @Transactional
    public RequestArchivistDto updateRequest(Long requestId, RequestUpdateDto requestUpdate) {
        RequestArchivist request = service.getRequest(requestId);
        mapping.updateRequest(request,requestUpdate);
        service.save(request);

        if (request.getRequestStatus()== RequestStatus.APPPROVED) {
            documentEndpoint.checkChoose(request.getDocument().getId());
        }

        return mapping.toDto(request);
    }
}
