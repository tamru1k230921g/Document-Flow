package com.example.documentFlow.requestArchivist.mapper.impl;

import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.requestArchivist.dto.RequestArchivistDto;
import com.example.documentFlow.requestArchivist.dto.RequestSendDto;
import com.example.documentFlow.requestArchivist.dto.RequestUpdateDto;
import com.example.documentFlow.requestArchivist.mapper.RequestArchivistMapping;
import com.example.documentFlow.requestArchivist.model.RequestArchivist;
import com.example.documentFlow.requestArchivist.model.RequestStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestArchivistMappingImpl implements RequestArchivistMapping {

    @Override
    @Transactional(readOnly = true)
    public RequestArchivistDto toDto(RequestArchivist requestArchivist) {
        RequestArchivistDto dto = new RequestArchivistDto();
        dto.setRequestMessage(requestArchivist.getRequestMessage());
        dto.setRequestStatus(requestArchivist.getRequestStatus());
        dto.setDocument(requestArchivist.getDocument().getId());
        dto.setOwner(requestArchivist.getOwner().getId());
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestArchivistDto> toDtos(List<RequestArchivist> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public RequestArchivist createRequest(Document document, RequestSendDto requestDto) {
        RequestArchivist request = new RequestArchivist();
        request.setRequestMessage(requestDto.getRequestMessage());
        request.setRequestStatus(RequestStatus.PENDING);
        request.setDocument(document);
        request.setOwner(document.getOwner());
        return request;
    }

    @Override
    @Transactional(readOnly = true)
    public RequestArchivist updateRequest(RequestArchivist request, RequestUpdateDto requestUpdate) {
        request.setRequestStatus(requestUpdate.getStatus());
        return request;
    }

}
