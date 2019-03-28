package com.soa.houzheng.person.repository;

import com.soa.houzheng.person.entity.UserCost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCostRepo extends JpaRepository<UserCost, Integer> {
    
}
