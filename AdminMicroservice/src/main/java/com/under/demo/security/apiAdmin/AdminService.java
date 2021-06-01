package com.under.demo.security.apiAdmin;

import com.under.demo.security.apiAdmin.Modele.InfosAdmin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository accountRepository;



    public InfosAdmin addAdmin(String username, String password) {
        return accountRepository.storeAdmin(username,password);
    }


    public String getUsers(){
        return accountRepository.getUsers();
    }





}
