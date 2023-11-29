package com.seffar.crm.dao.repository;

import com.seffar.crm.dao.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Integer> {
}
