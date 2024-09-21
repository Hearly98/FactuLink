package com.factulink.fkb.api.repository;


import com.factulink.fkb.api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepository extends JpaRepository<Client,Integer> {

}
