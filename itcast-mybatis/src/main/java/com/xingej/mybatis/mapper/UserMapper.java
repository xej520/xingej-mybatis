package com.xingej.mybatis.mapper;

import java.util.List;

import com.xingej.mybatis.po.User;
import com.xingej.mybatis.po.UserQueryVo;

public interface UserMapper {
    // 根据ID来查询用户信息
    public User findUserById(int id);

    // 根据用户名称来查询用户信息
    public List<User> findUserByName(String userName);

    //
    public List<User> findUserList(UserQueryVo userQueryVo);

    public void insertUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);
}
