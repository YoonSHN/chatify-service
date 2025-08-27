package com.chatify.app.core.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class LoginRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
