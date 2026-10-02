package com.melonest.auth.AuthTransformer;

import com.melonest.auth.AuthDto.Request.UserRegisterRequest;
import com.melonest.auth.AuthModels.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class toUser {
    public static User touser(UserRegisterRequest userRes) {
        return User.builder()
                .username(userRes.getUsername())
                .email(userRes.getEmail())
                .password(userRes.getPassword())
                .build();
    }
}
