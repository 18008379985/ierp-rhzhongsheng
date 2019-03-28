package com.soa.ierp.supplier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    List<Supplier> findByName(String name);

    Supplier findByUuid(String uuid);
}
