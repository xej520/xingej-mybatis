package com.xingej.mybatis.dao;

import java.util.List;

import com.xingej.mybatis.po.User;

public interface UserDao {

    // 根据id查询用户信息
    public User findUserById(int id) throws Exception;

    // 根据用户名称模糊查询用户列表
    public List<User> findUserByUsername(String username) throws Exception;

    // 插入用户
    public void insertUser(User user) throws Exception;

}