package com.soa.ierp.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String userName);
    List<Person> findByLeader(String leader);

    Person findByAccountsAndPassword(String userName, String password);
    Person findByUuid(String uuid);
}
