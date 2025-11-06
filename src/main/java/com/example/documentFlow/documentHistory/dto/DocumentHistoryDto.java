package com.example.documentFlow.documentHistory.dto;

import com.example.documentFlow.document.model.DocumentAction;
import com.example.documentFlow.document.model.Status;
import lombok.Data;

@Data
public class DocumentHistoryDto {

    private DocumentAction documentAction;
    private Long documentId;
    private String documentName;
    private String filePath;
    private String description;
    private Status status;
    private Long ownerId;
}
