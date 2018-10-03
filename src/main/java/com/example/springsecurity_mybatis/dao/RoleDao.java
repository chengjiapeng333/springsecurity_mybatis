package com.example.springsecurity_mybatis.dao;

import com.example.springsecurity_mybatis.entity.Role;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleDao {
    List<Role> findByUserName(String userName);

    Role findByRoleName(String name);

}
