package com.example.springsecurity_mybatis.entity;

import org.apache.ibatis.type.Alias;

@Alias(value = "user_role_rela")
public class UserRoleRela {
    private long userId;

    private long roleId;

    public UserRoleRela() {
    }

    public UserRoleRela(long userId, long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
