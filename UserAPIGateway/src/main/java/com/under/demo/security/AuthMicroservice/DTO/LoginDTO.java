package com.under.demo.security.AuthMicroservice.DTO;

import lombok.Data;

@Data
public class LoginDTO {

    private String username;
    private String password;
}
