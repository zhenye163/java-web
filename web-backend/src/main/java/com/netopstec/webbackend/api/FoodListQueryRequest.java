package com.netopstec.webbackend.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhenye 2020/5/7
 */
@Getter
@Setter
@ToString
public class FoodListQueryRequest extends PageQuery {

    private String name;

    private Date modifiedTimeStart;

    private Date modifiedTimeEnd;
}
