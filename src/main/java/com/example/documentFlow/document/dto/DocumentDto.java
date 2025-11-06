package com.example.documentFlow.document.dto;

import com.example.documentFlow.document.model.DocumentAction;
import com.example.documentFlow.document.model.Status;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DocumentDto {

    private Long Id;
    private String documentName;
    private String filePath;
    private String description;
    private Status status;
    private DocumentAction documentAction;
}
