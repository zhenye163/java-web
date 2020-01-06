package com.netopstec.easy_springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhenye 2020/1/6
 */
@Controller
public class UserController {

    @RequestMapping("/hello")
    public String hello(ModelMap map){
        map.addAttribute("message","Hello Spring MVC");
        return "hello";
    }
}
