package com.under.demo.security.crons.Repository;

import com.under.demo.security.database.Modele.Resource;
import com.under.demo.security.database.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.under.demo.security.database.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResourceRepository  extends JpaRepository<Resource, Long> {
    List<Resource> findAll();
}
