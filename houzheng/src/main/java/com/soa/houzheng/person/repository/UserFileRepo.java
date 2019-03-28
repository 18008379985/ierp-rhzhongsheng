package com.soa.houzheng.person.repository;

import com.soa.houzheng.person.entity.UserFile;
import com.soa.houzheng.person.entity.UserPwd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFileRepo extends JpaRepository<UserFile, Integer> {

}
