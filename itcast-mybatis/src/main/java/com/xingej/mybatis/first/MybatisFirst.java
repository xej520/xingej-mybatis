package com.xingej.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.xingej.mybatis.po.User;

public class MybatisFirst {
    // 声明一个全局的会话工厂
    SqlSessionFactory sqlSessionFactory = null;

    // 创建session工厂
    @Before
    public void init() throws IOException {
        // 1、配置文件(SqlMapConfig.xml)
        String resource = "SqlMapConfig.xml";
        // 2、加载配置文件，转换成流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 3、创建会话工厂SessionFactory

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    // 根据用户ID查询用户(得到单条记录)
    @Test
    public void testFindUserById() {
        // 1、通过session工厂来创建一个session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2、通过session会话来操作数据库
        // 第一个参数:statement位置:就是namespace + statement的id
        // 第2个参数：就是你传入的参数
        User user = null;

        try {
            user = sqlSession.selectOne("test.findUserById", 1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        System.out.println("----user-----:\t" + user);
    }

    // 根据用户名称来查询，
    // 返回结果是List类型
    // 支持模糊查询
    @Test
    public void testFindUserByName() {
        // 1、获取session会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2、操作数据库
        List<User> users = null;
        try {
            users = sqlSession.selectList("test.findUserByName", "小明");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        System.out.println("----->:\t" + users.get(2).getUsername());
    }

}
