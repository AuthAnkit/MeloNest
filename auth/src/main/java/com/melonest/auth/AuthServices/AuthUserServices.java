package com.melonest.auth.AuthServices;

import com.melonest.auth.AuthDto.Request.UserRegisterRequest;
import com.melonest.auth.AuthDto.Response.UserRegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthUserServices {
    public UserRegisterResponse registerUser(@RequestBody UserRegisterRequest request);
}
