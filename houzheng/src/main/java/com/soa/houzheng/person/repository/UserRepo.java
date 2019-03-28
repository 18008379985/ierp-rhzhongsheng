package com.soa.houzheng.person.repository;

import com.soa.houzheng.person.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findByName(String userName);
    User findByAccountsAndPassword(String userName, String password);
    User findByUuid(String uuid);
}
