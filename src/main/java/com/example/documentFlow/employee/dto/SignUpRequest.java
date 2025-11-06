package com.example.documentFlow.employee.dto;

import com.example.documentFlow.employee.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(description = "Запрос на регистрацию")
public class SignUpRequest {

    @Schema(description = "Имя пользователя", example = "Jonsnoy")
    @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Schema(description = "Адрес электронной почты", example = "Jonsnoy@gmail.com")
    @Size(min = 5, max = 255, message = "Адрес электронной почты должен содержать от 5 до 255 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;

    @Schema(description = "Роль пользователя", example = "USER/HR/HED/ARCHIVERUS")
    @NotNull(message = "Роль не может быть пустой")
    private Role role;

    @Schema(description = "Пароль", example = "My_1secret1_password")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&_#-])[A-Za-z\\d@$!%*?&_#-]{6,}$",
            message = "Пароль должен содержать хотя бы одну строчную букву, одну заглавную букву, одну цифру, один специальный символ (@$!%*?&_#-) и быть длиной от 6 символов"
    )
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private String password;
}