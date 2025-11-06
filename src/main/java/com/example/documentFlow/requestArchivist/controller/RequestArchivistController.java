package com.example.documentFlow.requestArchivist.controller;

import com.example.documentFlow.requestArchivist.dto.RequestArchivistDto;
import com.example.documentFlow.requestArchivist.dto.RequestSendDto;
import com.example.documentFlow.requestArchivist.dto.RequestUpdateDto;
import com.example.documentFlow.requestArchivist.endpoint.RequestArchivistEndpoint;
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
@RequestMapping(Paths.REQUEST_ARCHIVIST)
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "Отправка запроса архивариусу")
@SecurityRequirement(name = "JWT")
public class RequestArchivistController {

    RequestArchivistEndpoint endpoint;

    @Operation(summary = "Отправляем запрос архивариусу (только HEAD)")
    @PostMapping("/send/{documentId}")
    @PreAuthorize("hasRole('HEAD')")
    public RequestArchivistDto sendRequest(@PathVariable("documentId") Long documentId,
                                           @RequestBody RequestSendDto requestDto){
        return endpoint.createRequest(documentId, requestDto);
    }

    @Operation(summary = "Получить все запросы (только ARCHIVIST)")
    @GetMapping
    @PreAuthorize("hasRole('ARCHIVIST')")
    public List<RequestArchivistDto> getRequests(){
        return endpoint.getRequests();
    }

    @Operation(summary = "Подтвердить/отклонить статус запроса (только ARCHIVIST)")
    @PostMapping("/{requestId}")
    @PreAuthorize("hasRole('ARCHIVIST')")
    public RequestArchivistDto updateRequest(@PathVariable("requestId") Long requestId,
                                             @RequestBody RequestUpdateDto requestUpdate){
        return endpoint.updateRequest(requestId,requestUpdate);
    }

}
