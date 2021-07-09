package com.under.demo.security.user.Repository;

import com.under.demo.security.database.Modele.Dashboard;
import com.under.demo.security.database.Modele.Resource;
import com.under.demo.security.database.Modele.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DashboardRepository   extends JpaRepository<Dashboard, Long> {
    List<Dashboard> findAll();

    public List<Dashboard> getDashboardsById(int id);


}
