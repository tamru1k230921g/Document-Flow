package com.example.documentFlow.requestArchivist.mapper;

import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.requestArchivist.dto.RequestArchivistDto;
import com.example.documentFlow.requestArchivist.dto.RequestSendDto;
import com.example.documentFlow.requestArchivist.dto.RequestUpdateDto;
import com.example.documentFlow.requestArchivist.model.RequestArchivist;

import java.util.List;

public interface RequestArchivistMapping {

    RequestArchivistDto toDto(RequestArchivist requestArchivist);

    List<RequestArchivistDto> toDtos(List<RequestArchivist> entities);

    RequestArchivist createRequest(Document document, RequestSendDto requestDto);

    RequestArchivist updateRequest(RequestArchivist requestDto, RequestUpdateDto requestUpdate);
}
