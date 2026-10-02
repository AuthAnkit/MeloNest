package com.melonest.auth.AuthDto.Response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse {
    private String username;
    private String email;
}
