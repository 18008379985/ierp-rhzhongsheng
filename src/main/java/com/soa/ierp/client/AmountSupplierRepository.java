package com.soa.ierp.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmountSupplierRepository extends JpaRepository<AmountSupplier, Integer> {

    List<AmountSupplier> findByClientUuid(String clientUuid);
}
