package com.netopstec.easy_mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhenye 2020/1/9
 */
@Getter
@Setter
@ToString
public class User {

    private Long id;
    private String name;
    private String nick;
    private Integer age;
    private String hobby;

}
