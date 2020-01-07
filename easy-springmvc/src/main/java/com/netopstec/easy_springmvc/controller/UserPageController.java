package com.netopstec.easy_springmvc.controller;

import com.netopstec.easy_springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhenye 2020/1/6
 */
@Controller
@RequestMapping("/users")
public class UserPageController {

    @RequestMapping("/page")
    public ModelAndView showPage(){

        User user = new User();
        user.setName("戴振焱");
        user.setNick("zhenye");
        user.setAge(27);
        user.setHobby("动漫、炉石");
        ModelAndView modelAndView = new ModelAndView();
        // 处理并生成相应的模型user
        modelAndView.addObject(user);

        //指定视图
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
