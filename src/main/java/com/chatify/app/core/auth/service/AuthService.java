package com.chatify.app.core.auth.service;


import com.chatify.app.core.auth.dto.request.SendCodeRequest;
import com.chatify.app.core.auth.dto.request.SignupRequest;
import com.chatify.app.core.auth.dto.request.VerifyCodeRequest;
import com.chatify.app.core.auth.dto.response.VerificationToken;

public interface AuthService {

    VerificationToken sendVerificationCode(SendCodeRequest request);

    VerificationToken verifyCode(VerifyCodeRequest request);

    void signup(SignupRequest request);
}
