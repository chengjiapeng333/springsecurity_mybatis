package com.example.springsecurity_mybatis.controller;

import com.example.springsecurity_mybatis.dao.RoleDao;
import com.example.springsecurity_mybatis.dao.UserDao;
import com.example.springsecurity_mybatis.dao.UserRoleRelaDao;
import com.example.springsecurity_mybatis.entity.ResultMsg;
import com.example.springsecurity_mybatis.entity.User;
import com.example.springsecurity_mybatis.entity.UserRoleRela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private static final String NEWUSER_ROLE="ROLE_USER";

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleRelaDao userRoleRelaDao;

    @GetMapping("/checkusername/{username}")
    public ResultMsg exist(@PathVariable  String username) {
        System.out.println("获取到的用户名:"+username);
        if(StringUtils.isEmpty(username)) {
            return new ResultMsg(0, "用户名不能为空");
        }
        User user = userDao.getUserByUsername(username);
        if(user==null) {
            return new ResultMsg(1, "用户名可以使用");
        }else {
            return new ResultMsg(0, "用户名已被使用， 请重新输入");
        }
    }

    @PostMapping("/register/add")
    public ResultMsg addUser(@RequestBody User user) {
        String username =  user.getUsername();
        String password = user.getPassword();
        //先判断用户是否存在
        if(userDao.getUserByUsername(username)!=null) {
            return new ResultMsg(0, "用户已存在");
        }
        User addUser = new User();
        addUser.setUserName(username);
        addUser.setPassword(password);
        int result1 = userDao.addUser(addUser);
        if(result1==1) {
            long userId = addUser.getId();
            long roleId = roleDao.findByRoleName(NEWUSER_ROLE).getId();
            UserRoleRela userRoleRela = new UserRoleRela();
            userRoleRela.setUserId(userId);
            userRoleRela.setRoleId(roleId);
            int result2 = userRoleRelaDao.addRoleForUser(userRoleRela);
            if(result2==1) {
                return new ResultMsg(1, "注册成功");
            }else {
                return new ResultMsg(0, "注册失败");
            }
        }else {
            return new ResultMsg(0, "注册失败");
        }
    }


}
