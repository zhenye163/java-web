package com.netopstec.plan;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhenye 2020/4/11
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.plan")
public class PlanProperties {

    /**
     * 起床时间/睡觉结束时间
     */
    private String sleepTimeEnd = "08:00";

    /**
     * 早餐开始时间
     */
    private String breakfastTimeStart = "08:30";

    /**
     * 早餐结束时间
     */
    private String breakfastTimeEnd = "09:00";

    /**
     * 午餐开始时间
     */
    private String lunchTimeStart = "12:00";

    /**
     * 午餐结束时间
     */
    private String lunchTimeEnd = "12:30";

    /**
     * 晚餐开始时间
     */
    private String dinnerTimeStart = "19:00";

    /**
     * 晚餐结束时间
     */
    private String dinnerTimeEnd = "19:30";

    /**
     * 睡觉开始时间
     */
    private String sleepTimeStart = "00:00";
}
