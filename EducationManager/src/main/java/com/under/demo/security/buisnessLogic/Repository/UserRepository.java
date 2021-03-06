package com.under.demo.security.buisnessLogic.Repository;

import com.under.demo.security.database.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    List<User> findAll();
    User findByName(String username);

}
