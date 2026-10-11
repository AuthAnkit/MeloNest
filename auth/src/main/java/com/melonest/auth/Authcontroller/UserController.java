package com.melonest.auth.Authcontroller;

import com.melonest.auth.AuthDto.Request.UserLoginRequestEmail;
import com.melonest.auth.AuthDto.Request.UserLoginRequestUN;
import com.melonest.auth.AuthDto.Request.UserRegisterRequest;
import com.melonest.auth.AuthDto.Response.UserLoginResponse;
import com.melonest.auth.AuthDto.Response.UserRegisterResponse;
import com.melonest.auth.AuthServices.AuthUserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/api")
@RequiredArgsConstructor
public class UserController {
    private final AuthUserServices  authUserServices;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterRequest request) {
            UserRegisterResponse response = authUserServices.registerUser(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("User registered successfully: " + response.getUsername() + ", Email: " + response.getEmail());
    }

    @PostMapping("/loginUN")
    public  ResponseEntity<String> loginUserUN(@RequestBody UserLoginRequestUN request){
        System.out.println("LOGIN CONTROLLER REACHED");
        UserLoginResponse rep  =  authUserServices.loginUserUN(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body("User logged in successfully: Hello ," + rep.getUsername());
    }

    @PostMapping("/loginEmail")
    public  ResponseEntity<String> loginUserEmail(@RequestBody UserLoginRequestEmail request){
        UserLoginResponse rep = authUserServices.loginUserEmail(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body("User logged in successfully: Hello ," + rep.getUsername());
    }
}
