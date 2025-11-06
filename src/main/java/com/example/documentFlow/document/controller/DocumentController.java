package com.example.documentFlow.document.controller;

import com.example.documentFlow.document.dto.DocumentDto;
import com.example.documentFlow.document.dto.RequestDocument;
import com.example.documentFlow.document.dto.RequestSendDocument;
import com.example.documentFlow.document.endpoint.DocumentEndpoint;
import com.example.documentFlow.util.Paths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.DOCUMENT)
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "Взаимодействие с документом")
@SecurityRequirement(name = "JWT")
public class DocumentController {

    DocumentEndpoint endpoint;

    @Operation(summary = " Получение всех активных документов пользователя")
    @GetMapping("/active")
    public List<DocumentDto> getActiveDocuments(){
        return endpoint.getDocumentsForEmployee();
    }

    @Operation(summary = " Получение всех заархивированных документов пользователя")
    @GetMapping("/archive")
    public List<DocumentDto> getArchiveDocuments(){
        return endpoint.getArchiveDocuments();
    }

    @Operation(summary = "Создание документа")
    @PostMapping
    public DocumentDto create(@RequestBody RequestDocument document){
        return endpoint.createDocument(document);
    }

    @Operation(summary = "Изменение документа")
    @PutMapping("/{documentId}")
    public DocumentDto update(@RequestBody RequestDocument document,
                              @PathVariable("documentId") Long documentId
    )
    {
        return endpoint.updateDocument(documentId, document);
    }

    @Operation(summary = "Архивация документа (только HEAD)")
    @PostMapping("/{documentId}")
    @PreAuthorize("hasRole('HEAD')")
    public DocumentDto archiveDocument(@PathVariable("documentId") Long documentId){
        return endpoint.archiveDocument(documentId);
    }

    @Operation(summary = "Отправка документа")
    @PostMapping("/send/{documentId}")
    public DocumentDto sendDocument(@RequestBody RequestSendDocument targetEmployeeId,
                                    @PathVariable("documentId") Long documentId
    )
    {
        return endpoint.sendDocument(documentId, targetEmployeeId);
    }

}
