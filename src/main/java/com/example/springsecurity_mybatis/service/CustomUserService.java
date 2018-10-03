package com.example.springsecurity_mybatis.service;

import com.example.springsecurity_mybatis.dao.RoleDao;
import com.example.springsecurity_mybatis.dao.UserDao;
import com.example.springsecurity_mybatis.entity.Role;
import com.example.springsecurity_mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(s);
        if(user==null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("s:"+s);
        System.out.println("username:"+user.getUsername()+",password:"+user.getPassword());
        List<Role> roles = roleDao.findByUserName(user.getUserName());
        return chanageToUser(user, roles);
    }

    private UserDetails chanageToUser(User user, List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role:roles) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        UserDetails userDetails = new User(user.getId(), user.getUserName(), user.getPassword(), authorities);
        return userDetails;
    }
}
