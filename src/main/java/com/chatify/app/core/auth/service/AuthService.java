package com.chatify.app.core.auth.service;


import com.chatify.app.core.auth.dto.request.SignupRequest;

public interface AuthService {
    public abstract void signup(SignupRequest request);
}
