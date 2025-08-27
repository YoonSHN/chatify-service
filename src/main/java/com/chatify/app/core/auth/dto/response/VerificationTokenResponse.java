package com.chatify.app.core.auth.dto.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class VerificationTokenResponse {
    private String accessToken;
    private String refreshToken;
}
