package com.netopstec.spring_quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhenye 2019/12/17
 */
public class QuartJobTest {

    public static void main(String[] args) {
        // 启动Spring容器，并加载配置文件
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-quartz.xml");
        System.out.println("成功加载Spring容器...");
    }

}
