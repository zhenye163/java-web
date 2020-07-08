package com.netopstec.webbackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenye 2020/6/4
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/register")
    public void register() {

    }

    @PostMapping("/login")
    public void login() {

    }
}
