package com.netopstec.plan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhenye 2020/4/11
 */
public class PlanService {

    private PlanProperties planProperties;

    public PlanService(){}

    public PlanService(PlanProperties planProperties) {
        this.planProperties = planProperties;
    }

    public String formatPlanList() {
        checkPlan();
        String plan = "***   事项   ***     时间      ***" + "\n" +
                "*** 起床时间 ***     "+ planProperties.getSleepTimeEnd() + "     ***" + "\n" +
                "*** 早餐时间 *** "+ planProperties.getBreakfastTimeStart() + " - " + planProperties.getBreakfastTimeEnd() + " ***" + "\n" +
                "*** 午餐时间 *** "+ planProperties.getLunchTimeStart() + " - " + planProperties.getLunchTimeEnd() + " ***" + "\n" +
                "*** 晚餐时间 *** "+ planProperties.getDinnerTimeStart() + " - " + planProperties.getDinnerTimeEnd() + " ***" + "\n" +
                "*** 睡觉时间 ***     "+ planProperties.getSleepTimeStart() + "     ***";
        return plan;
    }

    private LinkedHashMap<String, String> getPlanMap() {
        LinkedHashMap<String, String> plan = new LinkedHashMap<>(8);
        plan.put("sleepTimeEnd", planProperties.getSleepTimeEnd());
        plan.put("breakfastTimeStart", planProperties.getBreakfastTimeStart());
        plan.put("breakfastTimeEnd", planProperties.getBreakfastTimeEnd());
        plan.put("lunchTimeStart", planProperties.getLunchTimeStart());
        plan.put("lunchTimeEnd", planProperties.getLunchTimeEnd());
        plan.put("dinnerTimeStart", planProperties.getDinnerTimeStart());
        plan.put("dinnerTimeEnd", planProperties.getDinnerTimeEnd());
        plan.put("sleepTimeStart", planProperties.getSleepTimeStart());
        return plan;
    }

    private void checkPlan () {
        LinkedHashMap<String, String> planMap = getPlanMap();
        if (compareTo(planMap.get("sleepTimeStart"), planMap.get("sleepTimeEnd"))  >= 0
                || compareTo(planMap.get("sleepTimeEnd"), planMap.get("breakfastTimeStart"))  >= 0
                || compareTo(planMap.get("breakfastTimeStart"), planMap.get("breakfastTimeEnd"))  >= 0
                || compareTo(planMap.get("breakfastTimeEnd"), planMap.get("lunchTimeStart"))  >= 0
                || compareTo(planMap.get("lunchTimeStart"), planMap.get("lunchTimeEnd"))  >= 0
                || compareTo(planMap.get("lunchTimeEnd"), planMap.get("dinnerTimeStart"))  >= 0
                || compareTo(planMap.get("dinnerTimeStart"), planMap.get("dinnerTimeEnd"))  >= 0) {
            throw new RuntimeException("作息时间制定有误");
        }
    }

    private Integer compareTo(String timeStr1, String timeStr2) {
        String[] timeStr1Split = timeStr1.split(":");
        Integer timeStr1Hour = Integer.valueOf(timeStr1Split[0]);
        Integer timeStr1Minute = Integer.valueOf(timeStr1Split[1]);
        String[] timeStr2Split = timeStr2.split(":");
        Integer timeStr2Hour = Integer.valueOf(timeStr2Split[0]);
        Integer timeStr2Minute = Integer.valueOf(timeStr2Split[1]);
        return timeStr1Hour * 60 + timeStr1Minute - timeStr2Hour * 60 - timeStr2Minute;
    }

    public String doing(Date date) {
        checkPlan();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String input = sdf.format(date);
        LinkedHashMap<String, String> planMap = getPlanMap();
        String doingThing;
        if (compareTo(input, planMap.get("sleepTimeStart"))  >= 0  && compareTo(input, planMap.get("sleepTimeEnd"))  < 0) {
            doingThing = "I am sleeping";
        } else if (compareTo(input, planMap.get("breakfastTimeStart"))  >= 0  && compareTo(input, planMap.get("breakfastTimeEnd"))  < 0) {
            doingThing = "I am eating my breakfast";
        }else if (compareTo(input, planMap.get("lunchTimeStart"))  >= 0  && compareTo(input, planMap.get("lunchTimeEnd"))  < 0) {
            doingThing = "I am eating my dinner";
        }else if (compareTo(input, planMap.get("dinnerTimeStart"))  >= 0  && compareTo(input, planMap.get("dinnerTimeEnd"))  < 0) {
            doingThing = "I am eating my dinner";
        } else {
            doingThing = "I have no idea what to do";
        }
        return doingThing;
    }

    public String nextTodo(Date date) {
        checkPlan();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String input = sdf.format(date);
        LinkedHashMap<String, String> planMap = getPlanMap();
        String nextTodo = "the next thing what to do for me is ";
        for (Map.Entry<String, String> entry : planMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (compareTo(input, value) < 0) {
                nextTodo += key + " at " + value;
                break;
            }
        }
        return nextTodo;
    }
}
