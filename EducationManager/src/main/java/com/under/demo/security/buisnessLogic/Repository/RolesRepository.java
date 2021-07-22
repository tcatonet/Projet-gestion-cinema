package com.under.demo.security.buisnessLogic.Repository;

import com.under.demo.security.database.Modele.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolesRepository  extends JpaRepository<Roles, Long> {

}
