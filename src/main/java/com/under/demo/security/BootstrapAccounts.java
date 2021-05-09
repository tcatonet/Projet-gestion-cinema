package com.under.demo.security;

import com.under.demo.security.user.Account;
import com.under.demo.security.user.AccountRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class BootstrapAccounts {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    BootstrapAccounts(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener
    void onStartup(ApplicationReadyEvent event) {
        List.of(
                new Account("under","under",passwordEncoder.encode("test"),List.of("USER")),
                new Account("admin","admin",passwordEncoder.encode("admintest"),List.of("USER","ADMIN"))
        ).forEach(accountRepository::save);
    }
}
