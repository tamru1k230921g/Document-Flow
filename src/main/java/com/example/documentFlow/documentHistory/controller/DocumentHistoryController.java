package com.example.documentFlow.documentHistory.controller;

import com.example.documentFlow.documentHistory.dto.DocumentHistoryDto;
import com.example.documentFlow.documentHistory.endpoint.DocumentHistoryEndpoint;
import com.example.documentFlow.util.Paths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.DOCUMENT)
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Tag(name = "История документа")
@SecurityRequirement(name = "JWT")
public class DocumentHistoryController {

    DocumentHistoryEndpoint endpoint;

    @Operation(summary = "Получить историю документа")
    @GetMapping("/{documentId}")
    public List<DocumentHistoryDto> getHistories(@PathVariable("documentId") Long documentId){
        return endpoint.getHistories(documentId);
    }
        


}
