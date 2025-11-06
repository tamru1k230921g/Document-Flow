package com.example.documentFlow.requestArchivist.dto;

import com.example.documentFlow.requestArchivist.model.RequestStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RequestArchivistDto {

    private String requestMessage;
    private RequestStatus requestStatus;
    private Long document;
    private Long owner;
}
