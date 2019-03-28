package com.soa.ierp.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientFileRepository extends JpaRepository<ClientFile, Integer> {

    List<ClientFile> findByClientUuid(String clientUuid);
}
