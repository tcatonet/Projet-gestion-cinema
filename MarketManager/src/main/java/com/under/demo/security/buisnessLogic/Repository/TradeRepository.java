package com.under.demo.security.buisnessLogic.Repository;

import com.under.demo.security.database.Modele.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findAll();
    List<Trade> findAllById(int id);

    Trade findById(int id);

}
