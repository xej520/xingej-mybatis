package com.xingej.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xingej.mybatis.po.User;

public class UserDaoImpl implements UserDao {

    // 此属性，可以通过1、构造方法注入，2、将来通过Sring方式注入
    private SqlSessionFactory sqlSessionFactory;

    // 将SqlSessionFactory注入
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {

        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 根据id查询用户信息
        User user = sqlSession.selectOne("test.findUserById", id);

        // 将里与spring整合后，就不需要你手动关闭了。
        sqlSession.close();

        return user;

    }

    @Override
    public List<User> findUserByUsername(String username) throws Exception {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list = sqlSession.selectList("test.findUserByName", username);

        sqlSession.close();

        return list;
    }

    @Override
    public void insertUser(User user) throws Exception {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.insert("test.insertUser", user);

        // 提交事务
        sqlSession.commit();

        sqlSession.close();

    }

}
