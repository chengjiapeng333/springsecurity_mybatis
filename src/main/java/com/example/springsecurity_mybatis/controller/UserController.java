package com.example.springsecurity_mybatis.controller;

import com.example.springsecurity_mybatis.dao.RoleDao;
import com.example.springsecurity_mybatis.dao.UserDao;
import com.example.springsecurity_mybatis.entity.Role;
import com.example.springsecurity_mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @GetMapping("getUser")
    public User getUser() {
        return userDao.getUser(1l);
    }

    @GetMapping("getRole")
    public List<Role> getRole() {
        return roleDao.findByUserName("zhangsan111");
    }

}
