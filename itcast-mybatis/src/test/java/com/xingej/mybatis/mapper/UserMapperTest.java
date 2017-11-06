package com.xingej.mybatis.mapper;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.xingej.mybatis.po.User;

public class UserMapperTest {
    // 先创建一个会话工厂
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        // 配置文件（SqlMapConfig.xml）
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    // 根据用户ID来查询用户信息
    @Test
    public void testFindUserById() {
        // 创建一个session
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);

        System.out.println("----mapper方式-----:\n" + user);
    }

    // 根据用户名称来查询用户信息
    @Test
    public void testFindUserByUserName() {
        // 创建一个session
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        List<User> userList = userMapper.findUserByName("小明");

        System.out.println("----mapper方式-----:\n" + userList.get(0).getUsername());
    }

    // 插入用户信息
    @Test
    public void testInsertUser() {
        // 创建一个session
        SqlSession session = sqlSessionFactory.openSession();

        // 产生代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();

        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setUsername("燕青");

        userMapper.insertUser(user);
        session.commit();

        System.out.println("----mapper方式-----:\n");
    }

    // 删除用户
    @Test
    public void testDeleteUser() {
        // 创建一个session
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        userMapper.deleteUser(1);

        session.commit();
    }

    // 更新用户
    @Test
    public void testUpdateUser() {
        // 创建一个session
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();

        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setUsername("燕青");
        user.setId(1);

        userMapper.updateUser(user);
        session.commit();
    }

}
