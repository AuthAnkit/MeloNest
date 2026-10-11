package com.melonest.auth.AuthServices.AuthUserServicesImpl;

import com.melonest.auth.AuthDto.Request.UserLoginRequestEmail;
import com.melonest.auth.AuthDto.Request.UserLoginRequestUN;
import com.melonest.auth.AuthDto.Request.UserRegisterRequest;
import com.melonest.auth.AuthDto.Response.UserLoginResponse;
import com.melonest.auth.AuthDto.Response.UserRegisterResponse;
import com.melonest.auth.AuthModels.User;
import com.melonest.auth.AuthRepo.UserRepository;
import com.melonest.auth.AuthServices.AuthUserServices;
import com.melonest.auth.AuthTransformer.toResponse;
import com.melonest.auth.AuthTransformer.toUser;
import com.melonest.auth.Exceptions.UserAlreadyExists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserServicesImpl implements AuthUserServices {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserRegisterResponse registerUser(@RequestBody UserRegisterRequest request){
       User user = toUser.touser(request);
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        Optional<User> existingUser2 = userRepository.findByusername(user.getUsername());
        if(existingUser.isPresent()){
            throw new UserAlreadyExists("User already exists: " + user.getEmail());
        }
        if(existingUser2.isPresent()){
            throw new UserAlreadyExists("User already exists: " + user.getUsername());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return toResponse.ToResponse(savedUser);
    }

    @Override
    public UserLoginResponse loginUserUN(@RequestBody UserLoginRequestUN request){
        User user = userRepository.findByusername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(user.getPassword()==null || !passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid username or password");
        }
        return new UserLoginResponse().builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    @Override
    public UserLoginResponse loginUserEmail(@RequestBody UserLoginRequestEmail request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(user.getPassword()==null || !passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid username or password");
        }
        return new UserLoginResponse().builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}
