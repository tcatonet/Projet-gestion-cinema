package com.under.demo.security.apiUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;


    public InfosUser addUser(String username, String password) {
        return accountRepository.storeUser(username,password);
    }


    public InfosUser updateOne(String userId, String userName,String newUserName, String userPassword, String newUserPassword) {
       return accountRepository.updateOne(userId, userName, newUserName , userPassword, newUserPassword);
    }


    public String getUser(String username, String password){
        return accountRepository.getUser(username, password);
    }

    public InfosUser findPasswordByUsername(String username){
        return accountRepository.findPasswordByUsername(username);
    }



}
