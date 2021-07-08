package com.under.demo.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class BootstrapAccounts {

    private final PasswordEncoder passwordEncoder;

    BootstrapAccounts(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


}
