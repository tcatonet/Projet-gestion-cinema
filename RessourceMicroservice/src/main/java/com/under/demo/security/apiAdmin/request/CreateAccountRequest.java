package com.under.demo.security.apiAdmin.request;

import lombok.Data;

@Data
public class CreateAccountRequest {
    private String id;
    private String currentUsername;
    private String newUsername;
    private String currentPassword;
    private String newPassword;
}
