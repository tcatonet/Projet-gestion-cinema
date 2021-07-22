package com.under.demo.security.buisnessLogic.Repository;

import com.under.demo.security.database.Modele.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DashboardRepository   extends JpaRepository<Dashboard, Long> {
    List<Dashboard> findAll();

    public List<Dashboard> getDashboardsById(int id);


}
