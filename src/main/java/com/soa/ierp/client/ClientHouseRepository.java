package com.soa.ierp.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientHouseRepository extends JpaRepository<ClientHouse, Integer> {

    List<ClientHouse> findByClientUuid(String clientUuid);
}
