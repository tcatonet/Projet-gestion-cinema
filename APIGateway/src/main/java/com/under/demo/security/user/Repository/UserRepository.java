package com.under.demo.security.user.Repository;

import com.under.demo.security.database.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    List<User> findAll();
    User findByName(String username);


    public List<User> getUserByName(String username);

}
