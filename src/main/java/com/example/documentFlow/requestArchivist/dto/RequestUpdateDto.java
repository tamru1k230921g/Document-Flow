package com.example.documentFlow.requestArchivist.dto;

import com.example.documentFlow.requestArchivist.model.RequestStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RequestUpdateDto {
    private RequestStatus Status;
}
