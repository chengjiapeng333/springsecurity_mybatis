package com.example.springsecurity_mybatis.dao;

import com.example.springsecurity_mybatis.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao {
    User getUser(Long id);

    User getUserByUsername(String userName);
}
