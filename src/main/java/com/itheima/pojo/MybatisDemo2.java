package com.itheima.pojo;

import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//mybatis代理开发
public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
//        加载mybatis的核心文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        获取sqlsession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        执行sql
       // List<User> users = sqlSession.selectList("test.selectAll");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);

        sqlSession.close();


    }
}
