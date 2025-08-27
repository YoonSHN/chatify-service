package com.chatify.app.core.auth.service;


import com.chatify.app.core.auth.dto.request.SignupRequest;
import com.chatify.app.core.auth.dto.response.VerificationTokenResponse;

public interface AuthService {

    VerificationTokenResponse sendVerificationCode(SendRequest request);

    VerificationTokenResponse verifyCode(verifyCodeRequest request);

    void signup(SignupRequest request);
}
