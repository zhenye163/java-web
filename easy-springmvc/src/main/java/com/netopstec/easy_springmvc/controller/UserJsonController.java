package com.netopstec.easy_springmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netopstec.easy_springmvc.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenye 2020/1/7
 */
@RestController
@RequestMapping("/users")
public class UserJsonController {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @GetMapping(value = "/json", produces="text/html;charset=UTF-8")
    public String showJson() {
        User user = new User();
        user.setName("戴振焱");
        user.setNick("zhenye");
        user.setAge(27);
        user.setHobby("动漫、炉石");
        String userInfo = null;
        try {
            userInfo = OBJECT_MAPPER.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
