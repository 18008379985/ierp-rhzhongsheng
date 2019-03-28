package com.soa.ierp.client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Page<Client> findByKhjl(Pageable page, String name);
    Page<Client> findByKhjlAndKhxm(Pageable page,String name,String clientName);
    Page<Client> findBySczj(Pageable page,String name);
    Page<Client> findBySczjAndKhxm(Pageable page,String name,String clientName);
    Page<Client> findByKhxm(Pageable page,String clientName);

    List<Client> findByKhjl(String name);
    List<Client> findByKhjlAndKhxm(String name,String clientName);
    List<Client> findBySczj(String name);
    List<Client> findBySczjAndKhxm(String name,String clientName);
    List<Client> findByKhxm(String clientName);

    Client findByUuid(String uuid);

    List<Client> findBySfzh(String sfzh);

}
