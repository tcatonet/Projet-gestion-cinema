package com.under.demo.security.user.Repository;

import com.under.demo.security.database.Modele.Dashboard;
import com.under.demo.security.database.Modele.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourceRepository  extends JpaRepository<Resource, Long> {

    @Query("select r from Resource as r ORDER BY r.id DESC")
    public List<Resource> getResource();

}
