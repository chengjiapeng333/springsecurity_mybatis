package com.example.springsecurity_mybatis.dao;

import com.example.springsecurity_mybatis.entity.UserRoleRela;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRelaDao {
    int addRoleForUser(UserRoleRela userRoleRela);
}
