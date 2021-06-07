package com.under.demo.security.AuthMicroservice.DTO;

import lombok.Data;

@Data
public class CreateAccountDTO {
    private String username;
    private String password;
}
