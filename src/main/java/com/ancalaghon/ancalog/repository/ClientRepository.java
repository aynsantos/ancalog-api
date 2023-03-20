package com.ancalaghon.ancalog.repository;

import com.ancalaghon.ancalog.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {



}
