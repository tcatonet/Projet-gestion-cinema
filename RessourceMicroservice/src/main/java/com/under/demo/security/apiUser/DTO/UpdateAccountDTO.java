package com.under.demo.security.apiUser.DTO;

import lombok.Data;

@Data
public class UpdateAccountDTO {
    private String id;
    private String currentUsername;
    private String newUsername;
    private String currentPassword;
    private String newPassword;
}
