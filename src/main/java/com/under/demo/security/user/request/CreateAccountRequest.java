package com.under.demo.security.user.request;

import lombok.Data;

@Data
public class CreateAccountRequest {
    private String id;
    private String currentUsername;
    private String newUsername;
    private String currentPassword;
    private String newPassword;
}
