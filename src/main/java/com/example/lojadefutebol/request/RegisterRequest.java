package com.example.lojadefutebol.request;

import com.example.lojadefutebol.Enums.UserRoles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String login;
    private String password;
    private UserRoles role;
}
