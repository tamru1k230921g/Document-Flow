package com.example.documentFlow.requestArchivist.endpoint;

import com.example.documentFlow.requestArchivist.dto.RequestArchivistDto;
import com.example.documentFlow.requestArchivist.dto.RequestSendDto;
import com.example.documentFlow.requestArchivist.dto.RequestUpdateDto;

import java.util.List;

public interface RequestArchivistEndpoint {

    RequestArchivistDto createRequest(Long documentId, RequestSendDto requestDto);

    List<RequestArchivistDto> getRequests();

    RequestArchivistDto updateRequest(Long documentId, RequestUpdateDto requestUpdate);
}


