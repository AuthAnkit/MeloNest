package com.melonest.auth.AuthDto.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginRequestUN {
    private String username;
    private String password;
}
