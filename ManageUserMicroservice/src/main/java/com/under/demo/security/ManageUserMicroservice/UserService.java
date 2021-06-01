package com.under.demo.security.ManageUserMicroservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository user;


    public void updateName() { user.updateName(); }

    public void updateEmail() {
        user.updateEmail();
    }

    public void updatePassword() { user.updatePassword();}

    public void deleteUser() { user.deleteUser();}

    public void getInfosUser() {
        user.getInfosUser();
    }


}
