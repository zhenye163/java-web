package com.netopstec.easy_mybatis.mapper;

import com.netopstec.easy_mybatis.entity.User;

import java.util.List;

/**
 * @author zhenye 2020/1/9
 */
public interface UserMapper {

    List<User> selectAll();

    int insertOne(User user);

}
