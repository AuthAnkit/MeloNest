package com.melonest.auth.AuthTransformer;

import com.melonest.auth.AuthDto.Response.UserRegisterResponse;
import com.melonest.auth.AuthModels.User;

public class toResponse {
    public static UserRegisterResponse ToResponse(User user) {
        return UserRegisterResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
