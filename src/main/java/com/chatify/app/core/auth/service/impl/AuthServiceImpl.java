package com.chatify.app.core.auth.service.impl;

import com.chatify.app.core.auth.dto.request.SignupRequest;
import com.chatify.app.core.auth.dto.response.VerificationTokenResponse;
import com.chatify.app.core.auth.service.AuthService;
import com.chatify.app.core.user.domain.User;
import com.chatify.app.core.user.domain.UserProfile;
import com.chatify.app.core.user.domain.UserSettings;
import com.chatify.app.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //이메일로 인증번호 보내고 임시 인증 토큰 받기
    @Override
    public VerificationTokenResponse sendVerificationCode(SendRequest request){
        return
    }

    @Override
    public VerificationTokenResponse verifyCode(verifyCodeRequest request){

    }


    /*
    자체 회원 가입
     */
    public void signup(SignupRequest signupRequest){
        if(userRepository.existsUserByEmail(signupRequest.getEmail())){
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }
        //1차 : 이메일에 발송된 이메일이 맞는지, 2차 : 이메일이 앱 내 고유한지

        User user = User.builder().
                email(signupRequest.getEmail()).
                password(passwordEncoder.encode(signupRequest.getPassword())).
                phoneNumber(signupRequest.getPhoneNumber()).build();

        UserProfile userProfile = UserProfile.create(user,
                signupRequest.getRealName(), signupRequest.getBirthday());

        UserSettings userSettings = UserSettings.create(user);

        // 객체 양쪽값 모두 저장
        user.setUserProfile(userProfile);
        user.setUserSettings(userSettings);

        userRepository.save(user);
    }



}
