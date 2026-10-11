package com.melonest.auth.AuthDto.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginRequestEmail {
    private String email;
    private String password;
}
