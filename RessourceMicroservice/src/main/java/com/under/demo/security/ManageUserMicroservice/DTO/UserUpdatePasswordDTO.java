package com.under.demo.security.ManageUserMicroservice.DTO;

import lombok.Data;

@Data
public class UserUpdatePasswordDTO {
    private int id;
    private String Password;
}
