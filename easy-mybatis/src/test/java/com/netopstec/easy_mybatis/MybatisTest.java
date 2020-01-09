package com.netopstec.easy_mybatis;

import com.netopstec.easy_mybatis.entity.User;
import com.netopstec.easy_mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhenye 2020/1/9
 */
public class MybatisTest {

    public static void main(String[] args) throws IOException {
        InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAll();
        System.out.println("新增之前，user表数据：" + userList);
        User user = new User();
        user.setName("戴振焱");
        user.setNick("zhenye");
        user.setAge(27);
        user.setHobby("动漫，炉石");
        userMapper.insertOne(user);
        userList = userMapper.selectAll();
        System.out.println("新增之后，user表数据：" + userList);

    }
}
