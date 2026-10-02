package com.melonest.auth.AuthDto.Request;

import jakarta.persistence.Column;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
    private String email;
    private String username;
    private String password;
}
