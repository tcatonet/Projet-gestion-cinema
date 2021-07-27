package com.under.demo.security.user;

import com.under.demo.security.database.Modele.User;
import com.under.demo.security.user.DAO.UserDAO;
import com.under.demo.security.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserDAO userDAO;
    UserRepository userRepository;



    @Override
    public void addUser(User user) {

        User usermodele = new User(user.getName(), user.getEmail() , user.getPassword());
        userRepository.save(usermodele);
    }
}
