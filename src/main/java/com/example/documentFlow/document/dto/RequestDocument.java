package com.example.documentFlow.document.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RequestDocument {

    @Schema(description = "Название документа", example = "Отчет за июль")
    @Size(min = 5, max = 50, message = "Название Документа должно содержать от 5 до 50 символов")
    @NotBlank(message = "Название документа не может быть пустыми")
    private String documentName;
    private String filePath;
    private String description;
}
