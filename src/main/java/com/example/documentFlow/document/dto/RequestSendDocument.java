package com.example.documentFlow.document.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RequestSendDocument {

    @NotBlank
    Long targetEmployeeId;
}
