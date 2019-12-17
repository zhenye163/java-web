package com.netopstec.spring_quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhenye 2019/12/17
 */
public class TimePrinterJob {
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public void printTime() {
        System.out.println("测试spring-xml配置quartz定时任务 TimePrinterJob.printTime() " + sdf.format(new Date()));
    }
}
