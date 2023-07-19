package com.sub.authen.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthInactiveUserResponse extends AuthUserLoginResponse{
    private String message;

    public static AuthInactiveUserResponse from(String message) {
        AuthInactiveUserResponse response = new AuthInactiveUserResponse();
        response.setMessage(message);
        return response;
    }
}

