package com.under.demo.security.ManageUserMicroservice;

import com.under.demo.security.ManageUserMicroservice.DTO.UserUpdateEmailDTO;
import com.under.demo.security.ManageUserMicroservice.DTO.UserUpdateNameDTO;
import com.under.demo.security.ManageUserMicroservice.DTO.UserUpdatePasswordDTO;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }


    private final UserService userService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");





    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/user/update/name")
    public void updateName(@RequestBody UserUpdateNameDTO userUpdateNameDTO) {
        userService.updateName();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/user/update/mail")
    public void updateMail(@RequestBody UserUpdateEmailDTO userUpdateEmailDTO) {
        userService.updateEmail();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/user/update/password")
    public void updatePassword(@RequestBody UserUpdatePasswordDTO userUpdatePasswordDTO) {
        userService.updatePassword();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/user/detele")
    public void deletePassword() {
        userService.deleteUser();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/user/get/user")
    public void getUser() {
        userService.getInfosUser();
    }

}
