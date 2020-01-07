package com.netopstec.easy_springmvc.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhenye 2020/1/6
 */
@Getter
@Setter
@ToString
public class User {

    private String name;
    private String nick;
    private Integer age;
    private String hobby;

}
