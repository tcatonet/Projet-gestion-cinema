package com.under.demo.security.user.DTO;

import lombok.Data;

@Data
public class CreateAccountDTO {
    private String id;
    private String name;
    private String email;
    private String password;
}
