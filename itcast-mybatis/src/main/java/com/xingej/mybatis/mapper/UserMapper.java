package com.xingej.mybatis.mapper;

import java.util.List;

import com.xingej.mybatis.po.User;

public interface UserMapper {
    // 根据ID来查询用户信息
    public User findUserById(int id);

    // 根据用户名称来查询用户信息
    public List<User> findUserByName(String userName);

    public void insertUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);
}
